package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Forgot;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/forgot")
public class forgotController {
    @Autowired
    private JavaMailSender javaMail;
    private RegisterRepository repo;

    @Autowired
    private forgotController(RegisterRepository repo){
        this.repo=repo;
    }
    @GetMapping
    public String showForgot(Model model){
        model.addAttribute("forgot",new Forgot());
        return "forgot";
    }

    @PostMapping
    public String processForgot(@Valid Forgot forgot){
        List<Register> pass=repo.findAllByEmailAddress(forgot.getEmailAddress());
        System.out.println(forgot.getEmailAddress());
        System.out.println(pass.get(0).getPassword());
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(forgot.getEmailAddress());
        msg.setSubject("Welcome to Voizfonica");
        msg.setText("Your password" + pass.get(0).getPassword());
        javaMail.send(msg);
        return "redirect:/help";
    }
}
