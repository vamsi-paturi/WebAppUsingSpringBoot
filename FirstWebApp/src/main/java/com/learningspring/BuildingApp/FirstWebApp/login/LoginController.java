

// USED WELCOME CONTROLLER TO REPLACE THIS FUNCTIONALITY WITH SPRING SECURITY IMPLEMENTATION

/*
package com.learningspring.BuildingApp.FirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService; // This will cause a null pointer exception as we havent initialized it with "= new authenticationservice", instead we are using constructor injection now to crack this service.


    // Constructor Injection  - Instead of wiring to a specific one only
    public LoginController(AuthenticationService authenticationService){
        super();
        this.authenticationService = authenticationService;
    }


    //private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "login", method = RequestMethod.GET)
    //http://localhost:8080/login?name=Vamsi --  For handling this name we are using request params
    public String gotoLoginPageJsp() {
//        logger.debug("Request param is {}", name); // Selecting the level at this log to be printed, here its debug level
//        logger.info("Printing at Info Level");
//        logger.warn("Printing only warnings");
       // System.out.println("Request Param is " + name);
        return "welcome";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String Password, ModelMap model){

        if (authenticationService.authenticate(name, Password)){

            model.put("Name", name);
//            model.put("Password", Password);

            return "welcome";

        }
        else {
            model.put("ErrorMessage" , "Invalid Cred's Please Try again!!!!" );

            return "login";
        }

    }

}
*/