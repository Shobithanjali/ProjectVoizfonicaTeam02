package com.example.voiz_team02.model;

import lombok.Data;
import lombok.var;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Document
@Data
public class Complaints {
    @Id
    private String Id;
        @NotBlank
        @Size(message ="Atleast 2 characters")
    private String comp;

   }
