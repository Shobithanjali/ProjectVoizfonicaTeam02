package com.example.voiz_team02.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class resultController {
    @ModelAttribute
    @GetMapping
    public String show_register(Model model){

        return "result";
    }
}
