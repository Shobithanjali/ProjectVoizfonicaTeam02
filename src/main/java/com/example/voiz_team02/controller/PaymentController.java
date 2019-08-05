package com.example.voiz_team02.controller;


import com.example.voiz_team02.data.OrderRepository;
import com.example.voiz_team02.data.PaymentRepository;
import com.example.voiz_team02.model.Order;
import com.example.voiz_team02.model.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
@Controller
@RequestMapping("/payment")
@SessionAttributes({"payment","order"})

public class PaymentController {
    private final PaymentRepository payRepo;
    private final OrderRepository orderRepo;

    public PaymentController(PaymentRepository payRepo, OrderRepository orderRepo) {
        this.payRepo = payRepo;
        this.orderRepo=orderRepo;
    }

    @ModelAttribute
    @GetMapping
    public String showPayment(Model model){
        model.addAttribute("payment",new Payment());
        return "payment";
    }
    @PostMapping
    public String processPayment(@Valid Payment payment, Errors errors, @ModelAttribute Order order, SessionStatus sessionStatus, Model model) {
        if (errors.hasErrors()) {
            return "payment";
        }
        order.setPayment(payment);
        payRepo.save(payment);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/success";
    }
}
