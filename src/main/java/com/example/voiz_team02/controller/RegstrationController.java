package com.example.voiz_team02.controller;


import com.example.voiz_team02.data.Regstrationrepo;
import com.example.voiz_team02.model.regstration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/regstration")
public class RegstrationController {
    private Regstrationrepo regstrationrepo;
    /*public String show_register(Model model){
         List<Register> mylist= Arrays.asList(
                 new register("varnika",999,"varnika@gmail.com","****")
         );
         model.addAttribute("account",mylist);

         return "register";

     }*/
    @Autowired
    public RegstrationController(Regstrationrepo regstrationrepo)
    {
        this.regstrationrepo=regstrationrepo;
    }
    @ModelAttribute(name="regstration")
    public regstration register()
    {
        return new regstration();
    }
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("regstration",new regstration());
        return "regstration";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/

    @PostMapping
    public String processRegister(@Valid regstration regstration, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "regstration";
        }
        else
        {
            regstrationrepo.save(regstration);
            model.addAttribute("regstration",new regstration());
            return "result";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        /* log.info("Processing design: " + register);*/


    }
}
