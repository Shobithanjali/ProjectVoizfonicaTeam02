package com.example.voiz_team02.model;
import lombok.Data;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Data
@Document
public class Register {
@Id
    private String _id;


    @NotBlank
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\.\\-]+)\\.([a-zA-Z]{2,5})$", message="give us a valid emailid")
    private String emailAddress;


    @NotBlank
    @Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",message="Your password should contain atleast 1 capital letter,1 number and 1 special character")
    private String password;


    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s]{2,20}$",message = "Give a valid name")
    private  String full_name;



    @Digits(integer=10,message="Invalid no", fraction = 0)
    private String mobile_no;

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String get_id() {
        return _id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }



}
