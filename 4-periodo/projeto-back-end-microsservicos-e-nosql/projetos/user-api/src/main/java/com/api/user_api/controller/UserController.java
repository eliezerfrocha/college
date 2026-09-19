package com.api.user_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    @GetMapping("/")
    public String getMensagem() {
        return "Hello, world! Springboot is working.";
    }
    
}
