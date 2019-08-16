package com.example.voiz_team02.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AccessLevel;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.RequiredArgsConstructor;
        import org.springframework.data.annotation.Id;
        import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor

public class PostpaidPlan {
    @Id
    private String id;
    private  String scheme;
    private  String value;
    private  String benefits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public PostpaidPlan(String Id, String scheme, String value, String benefits) {
        this.id = Id;

        this.scheme = scheme;
        this.value=value;
        this.benefits=benefits;
    }


}
