package com.example.voiz_team02.controller;
import com.example.voiz_team02.data.ComplaintsRepository;
import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Complaints;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/complaints")
@SessionAttributes("login")
public class ComplaintsController {
    @Autowired
    private RegisterRepository registerRepo;

    @Autowired
    public ComplaintsController(RegisterRepository registerRepo) {
        this.registerRepo=registerRepo;
    }

    @ModelAttribute(name = "register")
    public Register register(){ return new Register();
    }
    @Autowired
    private ComplaintsRepository comprep;
    public ComplaintsController(ComplaintsRepository comprep){
        this.comprep=comprep;
    }
    @ModelAttribute
    @GetMapping
    public String show_register(Model model, @SessionAttribute("login") Login login, @ModelAttribute Register register) {
        List<Register> myReg=registerRepo.findAllByEmailAddress(login.getEmailAddress());
        System.out.println(myReg);
        System.out.println(login.getEmailAddress());
        model.addAttribute("register",myReg.get(0));
        model.addAttribute("complaints", new Complaints());
        return "complaints";
    }

    @PostMapping
    public String processRegister(@Valid Complaints complaints, Errors errors) {
        if (errors.hasErrors()) {
            return "complaints";
        }
        comprep.save(complaints);
        return "redirect:/dashboard";
    }
}


