package com.example.pastebin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pastebin.entities.UserData;
import com.example.pastebin.services.UserService;

@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
       return "login";
    }

    @PostMapping("/login")
    public String loginData(@ModelAttribute("loginRequest") UserData userData, @RequestParam("username") String Username, @RequestParam("password") String Password, Model model) {
        //Set data
        userData.setNameuser(Username);
        userData.setPassworduser(Password);
        //Search data
        UserData authenticated = userService.authenticated(userData.getNameuser(), userData.getPassworduser());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getNameuser());
            userService.getUserTextById(Username, model);
            return "personalPage";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerData(@ModelAttribute("registerRequest") UserData userData, @RequestParam("username") String Username, @RequestParam("password") String Password) {
       //Set data
        userData.setNameuser(Username);
        userData.setPassworduser(Password);
        Username = Username.replaceAll("\\s+", "");
        UserData searchUser = userService.searchUser(Username);
        if (searchUser != null) {
            return "error_page";
        }else {
        // Add data to data base
        UserData registerUser = userService.registerUser(userData.getNameuser(), userData.getPassworduser());
        if(registerUser != null) {
            return "/login";
        }else{
            return "error_page";
        }
        }
    }
    
    @GetMapping("/personalPage")
    public String personalPage(@RequestParam("userLogin") String username, Model model) {
        model.addAttribute("userLogin", username);
        userService.getUserTextById(username, model);
        return "personalPage";
    }
    
}
