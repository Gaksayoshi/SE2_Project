package com.example.se2_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(value = "/user")
    public String user(){
        return "user";
    }
}
