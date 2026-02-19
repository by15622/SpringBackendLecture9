package com.example.demo.restdocs.controller;

import com.example.demo.restdocs.dto.RestDocsMemberResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class RestDocsMemberController {

    @GetMapping("/{id}")
    public RestDocsMemberResponse getMember(@PathVariable Long id) {
        return new RestDocsMemberResponse(id, "kim", "kim@test.com");
    }
}
