package com.sso.githubsso.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private ClientRegistration clientRegistration(){
//        return CommonOAuth2Provider.GITHUB.getBuilder("github")
//                .clientId("d6bd5142cc579d3cf7d3")
//                .clientSecret("eaede15923b68b3ec7233d346a980c7e83da61eeeaede15923b68b3ec7233d346a980c7e83da61ee")
//                .build();
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.oauth2Login();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
