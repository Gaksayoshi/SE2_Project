package com.example.se2_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/cpanel")
    public String showCpanel() {
        return "cpanel";
    }
}
