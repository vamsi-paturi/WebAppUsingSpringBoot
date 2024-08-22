package com.learningspring.BuildingApp.FirstWebApp.login;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import static org.springframework.security.config.Customizer.withDefaults;

import static org.springframework.security.authorization.method.AuthorizationAdvisorProxyFactory.withDefaults;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    }