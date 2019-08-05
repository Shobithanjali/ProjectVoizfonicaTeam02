package com.example.voiz_team02.controller;
/*import com.example.voiz_team02.data.RegisterRepository;*/
import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

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
    public String processRegister(@Valid Register register, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "register";
        }
        register_repo.save(register);
        return "redirect:/login";
    }

}
