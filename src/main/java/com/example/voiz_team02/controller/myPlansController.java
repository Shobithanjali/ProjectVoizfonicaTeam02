package com.example.voiz_team02.controller;

import com.example.voiz_team02.data.*;
import com.example.voiz_team02.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.voiz_team02.util.GeneratePdfReport;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/myPlans")
@SessionAttributes("login")
public class myPlansController {

    @Autowired
    private OrderRepository orderRepo;
    private DongleRepository dongleRepo;
    private PrepaidRepository prepaidRepo;
    private PostpaidRepositary postpaidRepo;

    @Autowired
    private myPlansController(OrderRepository orderRepo,DongleRepository dongleRepo,PrepaidRepository prepaidRepo,PostpaidRepositary postpaidRepo){
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


    @ModelAttribute(name = "dongle")
    public DonglePlans dongle(){
        return new DonglePlans();
    }

   /* private List<Login> convertToDTOs(List<Order> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }*/



    @GetMapping
    public String showUserPlans(Model model, @SessionAttribute("login") Login login, @ModelAttribute Order order) {
        List<Order> myPlans = orderRepo.findAllByuserId(login.getEmailAddress());
        if (myPlans.isEmpty()) {
            return "warning";
        } else {
            List<PostpaidPlan> postPlans = Arrays.asList();
            List<PrepaidPlans> prePlans = Arrays.asList();
            List<DonglePlans> donglePlans = Arrays.asList();
            for (Order i : myPlans) {
                if (donglePlans.isEmpty()) {
                    System.out.println("dongle*");
                    donglePlans = (List<DonglePlans>) dongleRepo.findAllById(i.getDongleId());
                }
                if (postPlans.isEmpty()) {
                    System.out.println("post*");
                    postPlans = (List<PostpaidPlan>) postpaidRepo.findAllById(i.getPostPaidId());
                    System.out.println(postPlans);
                }
                if (prePlans.isEmpty()) {
                    System.out.println("pre*");
                    prePlans = (List<PrepaidPlans>) prepaidRepo.findAllById(i.getPrePaidId());
                }
            }
            model.addAttribute("myPlans", myPlans);
            model.addAttribute("myDongle", donglePlans);
            model.addAttribute("myPostPlans", postPlans);
            model.addAttribute("myPrePlans", prePlans);
            return "myPlans";
       /* List<Order> myPlans=orderRepo.findAllByuserId(login.getEmailAddress());
        if(myPlans.isEmpty()){
            return "warning";
        }*/
     /*   else if(myPlans.size()==1) {
            List<PrepaidPlans> prePaidPlans = prepaidRepo.findAllById(myPlans.get(0).getPrePaidId());
            List<PostpaidPlan> postPaidPlans = postpaidRepo.findAllById(myPlans.get(0).getPostPaidId());
            model.addAttribute("myPlans",myPlans);
            model.addAttribute("myPrePlans",prePaidPlans);
            model.addAttribute("myPostPlans",postPaidPlans);
            System.out.println(prePaidPlans);
            System.out.println(postPaidPlans);
            System.out.println("1 pre or 1 post");
            return "myPlans";*/

      /*  else {
            List<PrepaidPlans> prePaidPlans = prepaidRepo.findAllById(myPlans.get(0).getPrePaidId());
            List<PostpaidPlan> postPaidPlans = postpaidRepo.findAllById(myPlans.get(0).getPostPaidId());
            List<DonglePlans> dongleDetails = dongleRepo.findAllById(myPlans.get(0).getDongleId());
            model.addAttribute("myPlans", myPlans);
            model.addAttribute("myPrePlans",prePaidPlans);
            model.addAttribute("myPostPlans",postPaidPlans);
            model.addAttribute("myDongle", dongleDetails);
            System.out.println(dongleDetails);
            System.out.println(("2 purchased"));
            return "myPlans";*/

        }

    }


   @RequestMapping(value = "/pdfReport",method = RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> invoiceReport(@SessionAttribute("login") Login login,@ModelAttribute Order order){
      /* List<Order> myPlans = (List<Order>) orderRepo.findAllByuserId(login.getEmailAddress());
       var postPlans= (var) postpaidRepo.findAllById(myPlans.get(0).getPostPaidId());
       var prePlans=(List<PrepaidPlans>) prepaidRepo.findAllById(myPlans.get(0).getPrePaidId());
       var donglePlans = (List<DonglePlans>)dongleRepo.findAllById(myPlans.get(0).getDongleId());*/

     /* List<Order> myPlans=(List<Order>) orderRepo.findAllByuserId(login.getEmailAddress());
      List<PrepaidPlans> prePlans=(List<PrepaidPlans>) prepaidRepo.findAllById(myPlans.get(0).getPrePaidId());
      List<PostpaidPlan> postPlans=(List<PostpaidPlan>) postpaidRepo.findAllById(myPlans.get(0).getPostPaidId());
      List<DonglePlans> donglePlans=(List<DonglePlans>) dongleRepo.findAllById(myPlans.get(0).getDongleId());*/
       List<Order> myPlans = (List<Order>) orderRepo.findAllByuserId(login.getEmailAddress());
       List<PostpaidPlan> postPlans = Arrays.asList();
       List<PrepaidPlans> prePlans = Arrays.asList();
       List<DonglePlans> donglePlans = Arrays.asList();
       for(Order i:myPlans) {
           if (donglePlans.isEmpty()) {
               System.out.println("dongle*");
               donglePlans = (List<DonglePlans>) dongleRepo.findAllById(i.getDongleId());
           }
           if (postPlans.isEmpty()) {
               System.out.println("post*");
               postPlans = (List<PostpaidPlan>) postpaidRepo.findAllById(i.getPostPaidId());
               System.out.println(postPlans);
           }
           if (prePlans.isEmpty()) {
               System.out.println("pre*");
               prePlans = (List<PrepaidPlans>) prepaidRepo.findAllById(i.getPrePaidId());
           }
       }
       System.out.println("end");

       System.out.println(donglePlans);
       System.out.println(prePlans);
       System.out.println(postPlans);
     /*  List<Order> myPlans=orderRepo.findAllByUserId(login.getEmailAddress());*/
        ByteArrayInputStream bis=GeneratePdfReport.invoiceReport(myPlans,donglePlans,postPlans,prePlans);

       HttpHeaders headers = new HttpHeaders();
       headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

       return ResponseEntity
               .ok()
               .headers(headers)
               .contentType(MediaType.APPLICATION_PDF)
               .body(new InputStreamResource(bis));
    }

}
