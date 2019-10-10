package com.dc.flightReservation.controller;

import com.dc.flightReservation.dao.UserRepository;
import com.dc.flightReservation.entities.User;
import com.dc.flightReservation.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/showReg")
    public String showRegistrationPage(){
        return "login/registerUser";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user")User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        userRepository.findById(0l);
        return "/login/login";
    }

    @GetMapping("/showLogin")
    public String login(){
        return "/login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        boolean loginResponse = securityService.login(email,password);

        if(loginResponse){
            return "findFlights";
        }else{
           modelMap.addAttribute("msg","Invalid UserName or Password. Please try again.");
           return "login/login";
        }
    }
}
