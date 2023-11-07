package com.spring.securitypractice.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationSuccessHandlerClass implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        var authorities = authentication.getAuthorities();

        var adminAuth = authorities.stream().filter(a -> a.getAuthority().equals("ADMIN")).findFirst();
        var userAuth = authorities.stream().filter(a -> a.getAuthority().equals("USER")).findFirst();

        if(adminAuth.isPresent())
            response.sendRedirect("/admin/home");
        else if(userAuth.isPresent())
            response.sendRedirect("/user");
        else
            response.sendRedirect("/error");


    }
}
