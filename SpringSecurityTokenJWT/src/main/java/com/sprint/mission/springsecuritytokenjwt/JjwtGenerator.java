package com.sprint.mission.springsecuritytokenjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.crypto.SecretKey;

public class JjwtGenerator {

  public static void main(String[] args) {

    System.out.println("--------------------- JJWT 라이브러리 사용 ---------------------");

    SecretKey secretKey = Jwts.SIG.HS256.key().build();


    String secretKeyString = Encoders.BASE64.encode(secretKey.getEncoded());
    System.out.println("비밀 키: " + secretKeyString);

    Instant now = Instant.now();

    String accessToken = Jwts.builder()
        .header().type("JWT").and()
        .subject("unsuk.song")
        .issuedAt(Date.from(Instant.now()))
        .expiration(Date.from(now.plus(1, ChronoUnit.HOURS)))
        .claim("role", "INSTRUCTOR")
        .claim("animal", "OWL")
        .signWith(secretKey)
        .compact();

    System.out.println("JWT 액세스 토큰: " + accessToken);

    try {
      Claims parsedClaims = Jwts.parser()
          .verifyWith(secretKey).build()
          .parseSignedClaims(accessToken)
          .getPayload();

      System.out.println("====== 토큰 검증 성공 ======");
      System.out.println("usb: " + parsedClaims.getSubject());
      System.out.println("iat: " + parsedClaims.getIssuedAt());
      System.out.println("exp: " + parsedClaims.getExpiration());
      System.out.println("role: " + parsedClaims.get("role"));
      System.out.println("animal: " + parsedClaims.get("animal"));

    } catch (Exception e) {
      System.err.println("토큰 검증 실패: " + e.getMessage());
    }

    analyzeJwtStructure(accessToken);
  }

  private static void analyzeJwtStructure(String jwt) {

    System.out.println("====== JWT 구조 분석 ======");
    String[] parts = jwt.split("\\.");

    if (parts.length == 3) {
      System.out.println("헤더 부분: " + parts[0]);
      System.out.println("페이로드 부분: " + parts[1]);
      System.out.println("서명 부분: " + parts[2]);

      try {
        byte[] headerBytes = java.util.Base64.getUrlDecoder().decode(parts[0]);
        byte[] payloadBytes = java.util.Base64.getUrlDecoder().decode(parts[1]);

        System.out.println("디코딩된 헤더: " + new String(headerBytes));
        System.out.println("디코딩된 페이로드: " + new String(payloadBytes));

      } catch (Exception e) {
        System.out.println("디코딩 과정에서 오류 발생 (정상적인 상황)");
      }
    }
  }
}
