package com.example.demo.controller.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVariableController {

    @GetMapping("/users2/{id}")
    @ResponseBody
    public String getUser(@PathVariable Long id) {
        return "userId=" + id;
    }
}