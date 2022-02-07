package ru.nikolay.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nikolay.springcourse.dao.PersonDAO;
import ru.nikolay.springcourse.models.Person;

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
    public String show(@PathVariable int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String formNew(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute Person person){
                personDAO.create(person);
                return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String formUpdate(@PathVariable int id, Model model){

        model.addAttribute("person", personDAO.show(id) );

        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Person person, @PathVariable int id){
        personDAO.update(id, person);
        return "people/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        personDAO.delete(id);
        return "redirect:/people";
    }



}
