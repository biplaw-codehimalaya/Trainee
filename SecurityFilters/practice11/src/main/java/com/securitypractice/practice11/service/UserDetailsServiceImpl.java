package com.securitypractice.practice11.service;

import com.securitypractice.practice11.entity.User;
import com.securitypractice.practice11.misc.SecurityUser;
import com.securitypractice.practice11.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepo.findByUsername(username);

        if(foundUser == null){
            throw new UsernameNotFoundException("Bad Credentials.");
        }
        return new SecurityUser(foundUser);
    }
}
