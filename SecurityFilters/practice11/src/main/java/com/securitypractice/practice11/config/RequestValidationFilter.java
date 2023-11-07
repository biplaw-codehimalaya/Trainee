package com.securitypractice.practice11.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class RequestValidationFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)  servletRequest;
        var httpResponse = (HttpServletResponse) servletResponse;

        String requestId = httpRequest.getHeader("Request-Id");
        if(requestId != null || requestId.isBlank()){
            httpResponse.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
