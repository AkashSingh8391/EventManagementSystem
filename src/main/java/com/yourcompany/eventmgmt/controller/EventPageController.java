package com.yourcompany.eventmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventPageController {

    @GetMapping("/shadi")
    public String shadi() { return "shadi"; }

    @GetMapping("/birthday")
    public String birthday() { return "birthday"; }

    @GetMapping("/anniversary")
    public String anniversary() { return "anniversary"; }

    @GetMapping("/party")
    public String party() { return "party"; }

    @GetMapping("/other")
    public String other() { return "other"; }

    @GetMapping("/events/show")
    public String showEvents() { return "show-events"; }
}
