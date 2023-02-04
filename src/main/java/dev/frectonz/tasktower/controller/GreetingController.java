package dev.frectonz.tasktower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GreetingController {
    @GetMapping("/hello")
    public String greeting(Principal principal) {
        return "Hello, " + principal.getName();
    }
}
