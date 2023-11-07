package com.securitypractice.practice11.config;


import com.securitypractice.practice11.entity.Roles;
import com.securitypractice.practice11.entity.User;
import com.securitypractice.practice11.repo.RoleRepo;
import com.securitypractice.practice11.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InitialConfig {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @PostConstruct
    void enterDatabase(){
        Roles adminRole = new Roles();
        adminRole.setName("ADMIN");
        Roles savedAdminRole = roleRepo.save(adminRole);

        Roles userRole = new Roles();
        userRole.setName("USER");
        Roles savedUserRole =roleRepo.save(userRole);

        //Creating a admin user
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setAddress("Jhapa");
        adminUser.setRoles(List.of(adminRole));
        userRepo.save(adminUser);

        //Crating normal user
        User normalUser = new User();
        normalUser.setUsername("user");
        normalUser.setPassword(passwordEncoder.encode("user"));
        normalUser.setAddress("KTM");
        normalUser.setRoles(List.of(userRole));
        userRepo.save(normalUser);


    }
}
