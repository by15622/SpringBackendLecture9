package com.sprint.mission.springsecurityjwtdemo.controller;

import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/api/user")
  public Map<String, Object> user(
      Authentication authentication
  ) {
    return Map.of(
        "message",
        "USER API SUCCESS",
        "username",
        authentication.getName()
    );
  }
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/api/admin")
  public Map<String, Object> admin(
      Authentication authentication
  ) {

    return Map.of(
        "message",
        "ADMIN API SUCCESS",
        "username",
        authentication.getName()
    );
  }
}