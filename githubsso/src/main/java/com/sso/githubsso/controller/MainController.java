package com.sso.githubsso.controller;


import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

    private Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String getHomepage(OAuth2AuthenticationToken token, Model model){
        logger.info(String.valueOf(token.getPrincipal()));
        model.addAttribute("token", String.valueOf(token.getPrincipal()));
        return "main";
    }
}
