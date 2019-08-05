package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Order;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/login")
@SessionAttributes({"login","order"})
public class LoginController{
    private RegisterRepository repo;

    @Autowired
    private LoginController(RegisterRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public String show_login(Model model) {
        model.addAttribute("login", new Login());
        model.addAttribute("order",new Order());
        return "login";
    }


    @PostMapping
    public String processLogin(@Valid @ModelAttribute Login login, Errors errors,Model model, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "login";
        }else {
            ArrayList<Register> user = repo.findByEmailAddressAndPassword(login.getEmailAddress(), login.getPassword());
            login.setEmailAddress(login.getEmailAddress());
            order.setUserId(login.getEmailAddress());
            if (user.isEmpty()) {
                return "login";
            }
            return "redirect:/dashboard";

        }
    }

    }


