package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController2 {

    @GetMapping("/hello2")
    @ResponseBody
    public String hello() {
        return "Hello, Spring MVC!";
    }
}