package com.example.voiz_team02.controller;
import com.example.voiz_team02.data.ComplaintsRepository;
import com.example.voiz_team02.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
@Controller
@RequestMapping("/complaints")
public class ComplaintsController {
    @Autowired
    private ComplaintsRepository comprep;
    public ComplaintsController(ComplaintsRepository comprep){
        this.comprep=comprep;
    }
    @ModelAttribute
    @GetMapping
    public String show_register(Model model) {
        model.addAttribute("complaints", new Complaints());
        return "complaints";
    }

    @PostMapping
    public String processRegister(@Valid Complaints complaints, Errors errors) {
        if (errors.hasErrors()) {
            return "complaints";
        }
        comprep.save(complaints);
        return "redirect:/compreg";
    }
}


