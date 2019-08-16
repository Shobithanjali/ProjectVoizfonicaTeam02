package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.DongleRepository;
import com.example.voiz_team02.data.OrderRepository;
import com.example.voiz_team02.data.PostpaidRepositary;
import com.example.voiz_team02.data.PrepaidRepository;
import com.example.voiz_team02.model.Login;
import com.example.voiz_team02.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoice")
@SessionAttributes("login")
public class InvoiceController {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private InvoiceController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    @GetMapping
    public String invoiceDisplay(@SessionAttribute("login") Login login){
        List<Order> myPlans=orderRepo.findAllByuserId(login.getEmailAddress());
        if(myPlans.isEmpty()){
            return "warning";
        }
        else
        return "invoice";
    }


    @PostMapping
    public String invoice(){
        return "redirect:/myPlans/pdfReport";
    }

}
