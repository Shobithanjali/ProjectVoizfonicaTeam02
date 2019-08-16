package com.example.voiz_team02.controller;

import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public String show_login(Model model) {

        return "error";
    }

}
