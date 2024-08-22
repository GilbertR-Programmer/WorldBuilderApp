package com.sparta.grr.worldbuilderapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/people")
    public String getPeople() {
        return "Arghhh";
    }


}
