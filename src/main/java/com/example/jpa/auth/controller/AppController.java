package com.example.jpa.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String home(){
        return "<h2>Welcome home</h2>";

    }

    @GetMapping("/user")
    public String user(){
        return "<h2>Welcome user</h2>";

    }

    @GetMapping("/admin")
    public String admin(){
        return "<h2>Welcome admin</h2>";

    }


    @GetMapping("/access-denied")
    public String accessDenied(){
        return "<h2>Access Denied</h2>";

    }
}
