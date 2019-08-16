package com.example.voiz_team02.controller;


import com.example.voiz_team02.data.Regstrationrepo;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.regstration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/regstration")
@SessionAttributes("login")
public class RegstrationController {
    @Autowired
    private JavaMailSender javaMail;
    @Autowired
    private Regstrationrepo regstrationrepo;
    /*public String show_register(Model model){
         List<Register> mylist= Arrays.asList(
                 new register("varnika",999,"varnika@gmail.com","****")
         );
         model.addAttribute("account",mylist);

         return "register";

     }*/

   /* public RegstrationController(Regstrationrepo regstrationrepo)
    {
        this.regstrationrepo=regstrationrepo;
    }*/

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
    public String processRegister(@Valid regstration regstration, Errors errors, Model model, @SessionAttribute("login")Login login) {

        if (errors.hasErrors()) {
            return "regstration";
        }
        else
        {
            SimpleMailMessage msg=new SimpleMailMessage();
            msg.setTo(login.getEmailAddress());
            msg.setSubject("New Connection in Voizfonica");
            msg.setText(String.valueOf(regstration.rand));
            javaMail.send(msg);
            regstrationrepo.save(regstration);

            return "result";
        }




    }
}
