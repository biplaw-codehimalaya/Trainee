package com.securitypractice.practice11.config;

import com.securitypractice.practice11.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        var authorities = authentication.getAuthorities();

        var authAdmin = authorities.stream().filter(a->a.getAuthority().equals("ADMIN"))
                .findFirst();

        var authUser = authorities.stream().filter(a ->a.getAuthority().equals("USER"))
                .findFirst();

        if(authAdmin.isPresent()){
            response.sendRedirect("/admin");
        }else if(authUser.isPresent()){
            response.sendRedirect("/user");
        }
        else{
            response.sendRedirect("/login");
        }

    }
}
