package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.OrderRepository;
import com.example.voiz_team02.data.PrepaidRepository;
import com.example.voiz_team02.model.Order;
import com.example.voiz_team02.model.PrepaidPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prepaid")
@SessionAttributes({"login","order"})
public class PrepaidController{
    @Autowired
    private OrderRepository orderRepo;
    private PrepaidRepository PrepaidRepo;
    @Autowired
    public PrepaidController(PrepaidRepository PrepaidRepo, OrderRepository orderRepo) {
        this.PrepaidRepo=PrepaidRepo;
        this.orderRepo=orderRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }
    @GetMapping
    public String show(Model model){
        List<PrepaidPlans> plans=new ArrayList<>();
        PrepaidRepo.findAll().forEach(i->plans.add(i));
        model.addAttribute("plans",plans);

        return "prepaid";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String processOrder(@PathVariable String id, @ModelAttribute Order order, Model model){
        order.setPrePaidId(id);
        orderRepo.save(order);
        return "redirect:/payment";
    }

    @PostMapping
    public String processPlanFrom(@Valid PrepaidController prepaidcontroller, Model model){
        model.addAttribute("payment",prepaidcontroller);
        return "redirect:/payment";
    }
}