package com.example.voiz_team02.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document


public class DonglePlans {
    @Id
    private  String id;

    private  String scheme;
    private  String benefits;

    public DonglePlans() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public DonglePlans(String id, String scheme, String benefits) {
   this.id=id;
   this.benefits=benefits;
   this.scheme=scheme;
    }
}
