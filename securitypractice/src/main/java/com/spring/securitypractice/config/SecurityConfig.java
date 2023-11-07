package com.spring.securitypractice.config;


import com.spring.securitypractice.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Creating a bean to use our userDetails serviec
    //Which fetches the user from the database.
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    //Since we provided our own implementation of UserDetailsService
    //We have to specify password encoder too.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Creating an auth provider.
    //It uses UserDetailsService and PasswordEncoder. So, setting it up.
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

//    @Bean
//    public AuthenticationManagerBuilder authenticationManager(AuthenticationManagerBuilder auth){
//        return auth.authenticationProvider(authenticationProvider());
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.formLogin().successHandler(new AuthenticationSuccessHandlerClass());
//        http.authorizeRequests()
//                .mvcMatchers("/").permitAll()
//                .mvcMatchers("/admin/**").hasAuthority("ADMIN")
//                .anyRequest().hasAuthority("USER");

        http.authorizeRequests().anyRequest().authenticated();
    }

}
