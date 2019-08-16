package com.example.voiz_team02.controller;
/*import com.example.voiz_team02.data.RegisterRepository;*/
import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private JavaMailSender javaMail;
    private RegisterRepository register_repo;

    @Autowired
    public RegisterController(RegisterRepository register_repo){
        this.register_repo=register_repo;
    }

    @ModelAttribute(name="register")
    public Register register(){
    return  new Register();
    }

    @GetMapping
    public String show_register(Model model){
    model.addAttribute("register",new Register());
    return "register";
    }

    @PostMapping
    public String processRegister(@Valid Register register, Errors errors, Model model) throws MessagingException {
        if (errors.hasErrors()) {
            return "register";
        }
      /*  SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(register.getEmailAddress());
        msg.setSubject("Welcome to Voizfonica");
        msg.setText("Hi "+register.getFull_name()+",Thank you for registering with Voizfonica");
        javaMail.send(msg);
        register_repo.save(register);
        return "redirect:/login";*/
       /* SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(register.getEmailAddress());
        msg.setSubject("Welcome to Voizfonica");
        msg.setText("Hi "+register.getFull_name()+",Thank you for registering with Voizfonica");
        javaMail.send(msg);
        register_repo.save(register);
        return "redirect:/login";*/
        MimeMessage msg=javaMail.createMimeMessage();
        /* MimeMessage message = javaMail.createMimeMessage();*/
        MimeMessageHelper helper = new MimeMessageHelper(msg,true);
        /* SimpleMailMessage helper=new SimpleMailMessage();*/
        helper.setTo(register.getEmailAddress());
        helper.setSubject("Welcome to Voizfonica");
        helper.setText("Hi "+register.getFull_name()+",Thank you for registering with Voizfonica");
        FileSystemResource file = new FileSystemResource("C:\\t.jpg");
        helper.addAttachment("1.jpg",file);
        javaMail.send(msg);
        register_repo.save(register);
        return "redirect:/login";
    }

}
