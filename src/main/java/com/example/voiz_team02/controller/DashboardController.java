package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@SessionAttributes("login")
public class DashboardController {
    @Autowired
    private RegisterRepository registerRepo;

    @Autowired
    public DashboardController(RegisterRepository registerRepo) {
        this.registerRepo=registerRepo;
    }

    @ModelAttribute(name = "register")
    public Register register(){ return new Register();
    }
  /*  @GetMapping("/dashboard")
    public String show2(Model model){
        return "dashboard";
    }*/
    @GetMapping()
    public String show(Model model, @SessionAttribute("login") Login login, @ModelAttribute Register register){
        List<Register> myReg=registerRepo.findAllByEmailAddress(login.getEmailAddress());
        System.out.println(myReg);
        System.out.println(login.getEmailAddress());
        model.addAttribute("register",myReg.get(0));
        return "dashboard";
    }
}
