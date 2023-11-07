package com.spring.securitypractice.controller;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }
}
