package com.yourcompany.eventmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String index(){ return "index"; } // signup page (index.html)

    @GetMapping("/login")
    public String login(){ return "login"; }

    @GetMapping("/home")
    public String home(){ return "home"; }
}
