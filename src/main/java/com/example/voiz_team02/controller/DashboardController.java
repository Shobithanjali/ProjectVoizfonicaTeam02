package com.example.voiz_team02.controller;

import com.example.voiz_team02.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping()
@SessionAttributes("login")
public class DashboardController {
    @GetMapping("/dashboard")
    public String show2(Model model){
        return "dashboard";
    }
    @GetMapping("/login/dashboard")
    public String show(Model model, @SessionAttribute("login") Login login){
        model.addAttribute("login",login.getEmailAddress());
        return "dashboard";
    }
}
