package com.example.pastebin.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pastebin.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserTextIdController {
    private final UserService userService;

    public UserTextIdController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> getUserIdByUsername(@PathVariable String username, @RequestParam("user_text") String text) {
        userService.getUserIdByUsername(username, text);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/personalPage?userLogin=" + username); // Replace with the actual URL
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER); // 303 status code
    }


}

