package ru.nikolay.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/finish")
    public String sayFinish(){
        return "first/finish";
    }
}
