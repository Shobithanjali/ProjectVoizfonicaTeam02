package com.example.voiz_team02.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.util.Random;

@Data
@Document
public class regstration {
    public long rand=(long) (Math.random()*100000000+9872100000L);
   /* Random random=new Random();
    public int rand=random.nextInt(9000000)+1000000;
    @NotBlank
    @Digits(integer = 10,message = "invalid mobile no",fraction = 0)*/

    @Id
    private String id;

    @Size(min = 2,message = "Atleast 2 characters")
    private String firstname;


    @Size(min = 2,message = "Atleast 2 characters")
    private String lastname;



    @Size(min = 10,message = "Atleast 30 characters")
    private String address;


    @Size(min = 5,message = "Atleast 5 characters")
    private String city;

    @Size(min = 5,message = "Atleast 5 characters")
    private String state;

    @Digits(integer=6, fraction=0, message="Invalid PIN Code")
    private String zip;

    @Digits(integer=12, fraction=0, message="Invalid aadhar number")
    private String aadhar;


    @Size(min = 3,message = "Invalid email")
    private String email;
}
