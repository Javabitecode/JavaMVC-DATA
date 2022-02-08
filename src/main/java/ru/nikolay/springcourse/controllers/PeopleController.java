package ru.nikolay.springcourse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.nikolay.springcourse.dao.PersonDAO;
import ru.nikolay.springcourse.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }


    @PostMapping()
    public String create(@ModelAttribute @Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";

    }
    /* заменен на @ModelAttribute
    @PostMapping()
    public String create(@RequestParam ("name") String name,
                         @RequestParam ("email") String email,
                         @RequestParam ("age") int age){
        Person person = new Person();
        person.setName(name);
        person.setEmail(email);
        person.setAge(age);
        personDAO.save(person);
        return "redirect:/people";
    }

     */

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id ){
        model.addAttribute("person", personDAO.show(id));

        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/edit";

        personDAO.update(id, person);

        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        personDAO.delete(id);
        return "redirect:/people";
    }


}
