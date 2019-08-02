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

public class Postpaidplan {
    @org.springframework.data.annotation.Id
    private String Id;
    private final String scheme;
    private final String value;
    private final String benefits;



}
