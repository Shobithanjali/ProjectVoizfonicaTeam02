package com.example.voiz_team02.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;

@Data
@Document
public class Feedback {
    @Id

    @NotBlank
    @Size(min = 2,message = "Atleast 2 characters")
    private  String full_name;
    @NotBlank
    @Size(min = 3,message = "Invalid email")
    private String email_address;
    @NotBlank
    @Digits(integer=10,message="Invalid no", fraction = 0)
    private String mobile_no;
    @NotBlank
    @Size(min = 1,message = "Atleast 1 character")
    private  String comments;
}
