package com.example.voiz_team02.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor
public class PrepaidPlans {
    @Id
    private String id;

    private String scheme;


    public PrepaidPlans(String id, String scheme) {
        this.id = id;

        this.scheme = scheme;
    }
}