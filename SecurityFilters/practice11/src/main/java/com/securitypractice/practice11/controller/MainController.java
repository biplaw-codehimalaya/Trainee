package com.securitypractice.practice11.controller;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public String getUserPage(){
        return "user";
    }

    @GetMapping("/video/{country}/{language}")
    public String getVideo(Model model, @PathVariable String country,
                           @PathVariable String language){
        model.addAttribute("country", country);
        model.addAttribute("language", language);
        return "video";
    }


    @GetMapping("/api/user")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>("HEllo User" , HttpStatus.OK);
    }



}
