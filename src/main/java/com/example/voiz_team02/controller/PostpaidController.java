package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.OrderRepository;
import com.example.voiz_team02.data.PostpaidRepositary;
import com.example.voiz_team02.model.Order;
import com.example.voiz_team02.model.Postpaidplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/postpaid")
@SessionAttributes("order")
public class PostpaidController {
    @Autowired
    private OrderRepository orderRepo;
    private PostpaidRepositary posrepo;
    @Autowired
    public PostpaidController(PostpaidRepositary posrepo, OrderRepository orderRepo) {
        this.posrepo=posrepo;
        this.orderRepo=orderRepo;
    }
    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }
    @GetMapping
    public String show_register(Model model){
        List<Postpaidplan> plans = new ArrayList<>();
        posrepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "Postpaid";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String processOrder(@PathVariable String id, @ModelAttribute Order order, Model model){
        order.setPostPaidId(id);
        orderRepo.save(order);
        return "redirect:/payment";
    }

    @PostMapping
    public String processPlanFrom(@Valid PostpaidController postpaidcontroller, Model model){
        model.addAttribute("payment",postpaidcontroller);
        return "redirect:/payment";
    }
}
