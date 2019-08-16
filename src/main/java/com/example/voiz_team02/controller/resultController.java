package com.example.voiz_team02.controller;


import com.example.voiz_team02.data.Regstrationrepo;
import com.example.voiz_team02.model.regstration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/result")
@SessionAttributes("login")
public class resultController {
    @Autowired
    private Regstrationrepo regstrationrepo;
    public resultController(Regstrationrepo regstrationrepo){
        this.regstrationrepo=regstrationrepo;
    }
    @ModelAttribute
    @GetMapping
    public String show_register(Model model){
        List<regstration> newcon=new ArrayList<>();
        regstrationrepo.findAll().forEach(i -> newcon.add(i));
        model.addAttribute("newcon", newcon);


        return "result";
    }
}
