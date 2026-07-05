package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }
}