package com.example.voiz_team02.controller;


import com.example.voiz_team02.data.FeedbackRepository;
import com.example.voiz_team02.data.RegisterRepository;
import com.example.voiz_team02.model.Feedback;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Register;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller

@RequestMapping("/feedback")
@SessionAttributes({"login","feedback"})

public class FeedbackController {
    @Autowired
    private RegisterRepository registerRepo;

    @Autowired
    public FeedbackController(RegisterRepository registerRepo) {
        this.registerRepo=registerRepo;
    }

    @ModelAttribute(name = "register")
    public Register register(){ return new Register();
    }
    private FeedbackRepository feedbackRepo;
    public FeedbackController(FeedbackRepository feedbackRepo){ this.feedbackRepo=feedbackRepo; }
    @ModelAttribute
    @GetMapping
    public String show_Feedback(Model model,  @SessionAttribute("login") Login login, @ModelAttribute Register register){
        List<Register> myReg=registerRepo.findAllByEmailAddress(login.getEmailAddress());
        System.out.println(myReg);
        System.out.println(login.getEmailAddress());
        model.addAttribute("register",myReg.get(0));
        model.addAttribute("feedback",new Feedback());
        return "feedback";
    }
    @PostMapping
    public String processFeedback(@Valid Feedback Feedback, Errors errors) {
        if (errors.hasErrors()) {
            return "feedback";
        }
        feedbackRepo.save(Feedback);
        return "redirect:/dashboard";
    }
}
