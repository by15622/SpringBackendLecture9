package com.example.demo.controller.model;

import com.example.demo.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModelAttributeController {

    @PostMapping("/users/form")
    @ResponseBody
    public String submit(@ModelAttribute UserRequest form) {
        return "name=" + form.getName() + ", age=" + form.getAge();
    }
}