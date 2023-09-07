package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "hello";
    }
    @PostMapping("/")
    String postName(@RequestParam("name") String responseVal, Model model) {
        model.addAttribute("name", responseVal);
        return "hello";
    }
}
