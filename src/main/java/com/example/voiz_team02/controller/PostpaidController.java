package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.PostpaidRepositary;
import com.example.voiz_team02.model.Postpaidplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/postpaid")
public class PostpaidController {
    @Autowired
    private PostpaidRepositary posrepo;
    @GetMapping
    public String show_register(Model model){
        List<Postpaidplan> plans = new ArrayList<>();
        posrepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "Postpaid";
    }
}
