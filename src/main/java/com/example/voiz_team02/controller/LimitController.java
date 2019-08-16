package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.DongleRepository;
import com.example.voiz_team02.data.OrderRepository;
import com.example.voiz_team02.data.PostpaidRepositary;
import com.example.voiz_team02.data.PrepaidRepository;
import com.example.voiz_team02.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/limit")
@SessionAttributes("login")
public class LimitController {

    @Autowired
    private OrderRepository orderRepo;
    private DongleRepository dongleRepo;
    private PrepaidRepository prepaidRepo;
    private PostpaidRepositary postpaidRepo;

    @Autowired
    private LimitController(OrderRepository orderRepo,DongleRepository dongleRepo,PrepaidRepository prepaidRepo,PostpaidRepositary postpaidRepo){
        this.orderRepo=orderRepo;
        this.dongleRepo=dongleRepo;
        this.prepaidRepo=prepaidRepo;
        this.postpaidRepo=postpaidRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }


    @ModelAttribute(name = "login")
    public Login login(){ return new Login();
    }

    @GetMapping
    public String show_limit(Model model, @SessionAttribute("login") Login login, @ModelAttribute Order order){
        List<Order> myPlans=orderRepo.findAllByuserId(login.getEmailAddress());
        List<PrepaidPlans> prePaidPlans = prepaidRepo.findAllById(myPlans.get(0).getPrePaidId());
        List<PostpaidPlan> postPaidPlans = postpaidRepo.findAllById(myPlans.get(0).getPostPaidId());
        List<DonglePlans> dongleDetails = dongleRepo.findAllById(myPlans.get(1).getDongleId());
        model.addAttribute("myPlans", myPlans);
        model.addAttribute("myPrePlans",prePaidPlans);
        model.addAttribute("myPostPlans",postPaidPlans);
        model.addAttribute("myDongle", dongleDetails);
        System.out.println(dongleDetails);
        System.out.println(("displayed in limit"));
        return "limit";
    }
}
