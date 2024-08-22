package com.learningspring.BuildingApp.FirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username,  String password){
        boolean isValidUserName = username.equalsIgnoreCase("vamsi2199");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");
        return isValidUserName && isValidPassword;
    }
}
