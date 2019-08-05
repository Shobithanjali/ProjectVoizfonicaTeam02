package com.example.voiz_team02.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.Valid;
@Data
@Document
public class Order {
    @Id
    private String idOrder;
   /* public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostPaidId() {
        return postPaidId;
    }

    public void setPostPaidId(String postPaidId) {
        this.postPaidId = postPaidId;
    }

    public String getDongleId() {
        return dongleId;
    }

    public void setDongleId(String dongleId) {
        this.dongleId = dongleId;
    }



    private String userId;
    private String prePaidId;
    private String postPaidId;
    private String dongleId;

    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(@Valid Payment payment) {
        this.payment = payment;
    }

    public String getPrePaidId() {
        return prePaidId;
    }

    public void setPrePaidId(String prePaidId) {
        this.prePaidId = prePaidId;
    }
}
