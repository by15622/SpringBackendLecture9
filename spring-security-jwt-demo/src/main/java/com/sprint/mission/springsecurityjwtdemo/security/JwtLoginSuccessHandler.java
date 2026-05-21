package com.sprint.mission.springsecurityjwtdemo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.mission.springsecurityjwtdemo.dto.LoginSuccessResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtLoginSuccessHandler
    implements AuthenticationSuccessHandler {

  private final JwtTokenProvider jwtTokenProvider;
  private final ObjectMapper objectMapper;
  private final RefreshTokenStore refreshTokenStore;

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication
  ) throws IOException, ServletException {

    UserDetails userDetails =
        (UserDetails) authentication.getPrincipal();

    String accessToken =
        jwtTokenProvider.generateAccessToken(userDetails);

    // 1. refresh token 생성 및 쿠키 설정 (writeValue 전에)
    String refreshToken =
        jwtTokenProvider.generateRefreshToken();

    refreshTokenStore.save(
        refreshToken,
        userDetails.getUsername()
    );

    jakarta.servlet.http.Cookie refreshCookie =
        new jakarta.servlet.http.Cookie(
            "REFRESH_TOKEN",
            refreshToken
        );

    refreshCookie.setHttpOnly(true);
    refreshCookie.setSecure(false);
    refreshCookie.setPath("/api/auth");
    refreshCookie.setMaxAge(7 * 24 * 60 * 60);

    response.addCookie(refreshCookie);

    // 2. 응답 설정
    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setCharacterEncoding("UTF-8");

    LoginSuccessResponse responseBody =
        LoginSuccessResponse.builder()
            .success(true)
            .accessToken(accessToken)
            .tokenType("Bearer")
            .username(userDetails.getUsername())
            .build();

    // 3. 응답 바디 작성 (마지막)
    objectMapper.writeValue(
        response.getWriter(),
        responseBody
    );

    log.info("JWT login success: {}", userDetails.getUsername());
  }
}