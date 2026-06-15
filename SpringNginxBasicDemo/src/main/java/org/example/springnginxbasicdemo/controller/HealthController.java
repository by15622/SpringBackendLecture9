package org.example.springnginxbasicdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

  @Value("${INSTANCE_NAME:unknown}")
  private String instanceName;

  @GetMapping("/api/health")
  public Map<String, Object> health(
      HttpServletRequest request
  ) {

    return Map.of(
        "status", "UP",
        "instance", instanceName,
        "host", request.getServerName(),
        "serverPort", request.getServerPort(),
        "xForwardedProto",
        getHeader(request, "X-Forwarded-Proto"),
        "xForwardedFor",
        getHeader(request, "X-Forwarded-For"),
        "xRealIp",
        getHeader(request, "X-Real-IP")
    );
  }

  private String getHeader(
      HttpServletRequest request,
      String name
  ) {

    String value = request.getHeader(name);

    if (value == null || value.isBlank()) {
      return "없음";
    }

    return value;
  }
}
