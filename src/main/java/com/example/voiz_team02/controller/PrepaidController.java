package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.PrepaidRepository;
import com.example.voiz_team02.model.PrepaidPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prepaid")
public class PrepaidController{
    @Autowired
    private PrepaidRepository PrepaidRepo;
    @GetMapping
    public String show(Model model){
        List<PrepaidPlans> plans=new ArrayList<>();
        PrepaidRepo.findAll().forEach(i->plans.add(i));
        model.addAttribute("plans",plans);

        return "prepaid";
    }
}