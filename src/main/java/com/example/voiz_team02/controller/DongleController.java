package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.DongleRepository;

import com.example.voiz_team02.data.OrderRepository;
import com.example.voiz_team02.model.DonglePlans;


import com.example.voiz_team02.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dongle")
@SessionAttributes({"login","order"})
public class DongleController {
    @Autowired
    private OrderRepository orderRepo;
    private DongleRepository donRepo;

    @Autowired
    public DongleController(DongleRepository donRepo, OrderRepository orderRepo) {
        this.donRepo=donRepo;
        this.orderRepo=orderRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @GetMapping
    public String showPlans(Model model){
        List<DonglePlans> plans=new ArrayList<>();
        donRepo.findAll().forEach(i->plans.add(i));
        model.addAttribute("plans",plans);
        return "dongle";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String processOrder(@PathVariable String id, @ModelAttribute Order order, Model model){
        order.setDongleId(id);
        orderRepo.save(order);
        return "redirect:/payment";
    }

    @PostMapping
    public String processPlanFrom(@Valid DongleController donglecontroller, Model model){
        model.addAttribute("payment",donglecontroller);
        return "redirect:/payment";
    }

}
