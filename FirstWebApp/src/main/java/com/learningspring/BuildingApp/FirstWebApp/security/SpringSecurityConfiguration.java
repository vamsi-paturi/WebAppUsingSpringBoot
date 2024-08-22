package com.learningspring.BuildingApp.FirstWebApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;

@Controller
public class SpringSecurityConfiguration {

    // We use LDAP or a Datatbase to store the creds
    // In Memory user details is used here in this class

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails userDetails= User.withDefaultPasswordEncoder()
                .username("Vamsi")
                .password("dummy")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }


}
