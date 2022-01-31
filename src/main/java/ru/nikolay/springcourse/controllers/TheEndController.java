package ru.nikolay.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheEndController {

    @GetMapping("/end")
    public String sayEnd(){
        return "second/theEnd";
    }
}
