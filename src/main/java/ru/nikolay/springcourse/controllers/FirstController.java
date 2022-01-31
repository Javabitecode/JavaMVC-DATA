package ru.nikolay.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/start")
    public String sayStart(@RequestParam(value = "name", required = false)String name,
                           @RequestParam(value = "surname", required = false) String surname){


        System.out.println("Hello " + name +" " + surname);

        return "first/start";
    }

    @GetMapping("/start/calculator")
    public String sayStart(HttpServletRequest request, Model model){

        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String action = request.getParameter("action");
        String result;
        if (action.equals("multi")){
            result = String.valueOf((Integer.valueOf(a)*Integer.valueOf(b)));
        }else if (action.equals("addition")){
            result = String.valueOf((Integer.valueOf(a)+Integer.valueOf(b)));
        }else if (action.equals("sub")){
            result = String.valueOf((Integer.valueOf(a)-Integer.valueOf(b)));
        }else {
            result = String.valueOf((Integer.valueOf(a)/Integer.valueOf(b)));
        }

        model.addAttribute("massage", result + " ");




        return "first/calculator";
    }

}
