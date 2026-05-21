package com.sprint.mission.springsecuritytokenjwt;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

public class NimbusJoseGenerator {

  public static void main(String[] args) {

    System.out.println("--------------------- Nimbus 라이브러리 사용 ---------------------");


    byte[] secretKey = new byte[32];
    new SecureRandom().nextBytes(secretKey);

    String secretKeyString = Base64.getEncoder().encodeToString(secretKey);
    System.out.println("비밀 키: " + secretKeyString);

    Instant now = Instant.now();

    try {
      JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256)
          .type(JOSEObjectType.JWT)
          .build();

      JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
          .subject("unsuk.song")
          .issueTime(Date.from(now))
          .expirationTime(Date.from(now.plus(1, ChronoUnit.HOURS)))
          .claim("role", "INSTRUCTOR")
          .claim("animal", "OWL")
          .build();

      SignedJWT signedJWT = new SignedJWT(header, claimsSet);
      JWSSigner signer = new MACSigner(secretKey);
      signedJWT.sign(signer);

      String accessToken = signedJWT.serialize();

      System.out.println("JWT 액세스 토큰: " + accessToken);

      try {
        SignedJWT parsedJWT = SignedJWT.parse(accessToken);

        JWSVerifier verifier = new MACVerifier(secretKey);
        if (parsedJWT.verify(verifier)) {
          JWTClaimsSet parsedClaims = parsedJWT.getJWTClaimsSet();

          System.out.println("====== 토큰 검증 성공 ======");
          System.out.println("sub: " + parsedClaims.getSubject());
          System.out.println("iat: " + parsedClaims.getIssueTime());
          System.out.println("exp: " + parsedClaims.getExpirationTime());
          System.out.println("role: " + parsedClaims.getClaim("role"));
          System.out.println("animal: " + parsedClaims.getClaim("animal"));
        } else {
          System.err.println("토큰 서명 검증 실패");
        }

      } catch (Exception e) {
        System.err.println("토큰 검증 실패: " + e.getMessage());
      }

      analyzeJwtStructure(accessToken);

    } catch (Exception e) {
      System.err.println("JWT 토큰 생성 실패: " + e.getMessage());
    }
  }

  private static void analyzeJwtStructure(String jwt) {

    System.out.println("====== JWT 구조 분석 ======");
    String[] parts = jwt.split("\\.");

    if (parts.length == 3) {
      System.out.println("헤더 부분: " + parts[0]);
      System.out.println("페이로드 부분: " + parts[1]);
      System.out.println("서명 부분: " + parts[2]);

      try {
        byte[] headerBytes = Base64.getUrlDecoder().decode(parts[0]);
        byte[] payloadBytes = Base64.getUrlDecoder().decode(parts[1]);

        System.out.println("디코딩된 헤더: " + new String(headerBytes));
        System.out.println("디코딩된 페이로드: " + new String(payloadBytes));

      } catch (Exception e) {
        System.out.println("디코딩 과정에서 오류 발생 (정상적인 상황)");
      }
    }
  }
}
