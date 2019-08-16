package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/editprofile")
@SessionAttributes("login")
public class EditprofController {
    private RegisterRepository registerRepository;
    private String userId;
    @Autowired
    private EditprofController(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;

    }

    @ModelAttribute(name = "register")
    public Register register() {
        return new Register();
    }

    @ModelAttribute(name = "login")
    public Login login(){
        return new Login();
    }
    @GetMapping
    public String getEdit(Model model,
                          @ModelAttribute Login login) {
        Register user = registerRepository.findByEmailAddress(login.getEmailAddress());

        model.addAttribute("user", user);
        return "editprofile";
    }
    @PostMapping
    public String setChanges(@Valid Register register, Errors errors, Model model){
      /*  String email=register.getEmailAddress();*/


        /* registerRepository.findOne(email);*/


        Register user1=new Register();
        user1.set_id(register.get_id());
        user1.set_id(register.get_id());
        user1.setFull_name(register.getFull_name());
        user1.setMobile_no(register.getMobile_no());
        user1.setEmailAddress(register.getEmailAddress());
        user1.setPassword(register.getPassword());
        registerRepository.save(register);
        return "redirect:/dashboard";

    }


}

