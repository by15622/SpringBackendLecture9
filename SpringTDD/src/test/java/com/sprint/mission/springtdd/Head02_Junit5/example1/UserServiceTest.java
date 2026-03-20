package com.sprint.mission.springtdd.Head02_Junit5.example1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

  @BeforeEach
  void setUp() {
    System.out.println("UserServiceTest - 각 테스트 시작 전 셋업 실행");
  }

  @AfterEach
  void tearDown() {
    System.out.println("UserServiceTest - 각 테스트 종료 후 정리 실행");
  }

  @Test
  void test1() {
    System.out.println("첫 번째 테스트 실행 중...");
    assertTrue(true);
  }

  @Test
  void test2() {
    System.out.println("두 번째 테스트 실행 중...");
    assertNotNull("Hello");
  }
}