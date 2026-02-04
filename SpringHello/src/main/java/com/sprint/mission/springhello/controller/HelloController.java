package com.sprint.mission.springhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController      // HTTP 요청을 처리하는 컨트롤러임을 선언
public class HelloController {

    @GetMapping("/hello")  // GET /hello 요청 매핑
    public String hello() {
        return "Hello Spring MVC!";
    }
}