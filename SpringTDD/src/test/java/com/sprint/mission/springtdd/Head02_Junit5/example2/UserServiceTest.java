package com.sprint.mission.springtdd.Head02_Junit5.example2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

  private UserService userService;

  @BeforeEach
  void setUp() {
    System.out.println("BeforeEach 실행");
    userService = new UserService();
  }

  @AfterEach
  void tearDown() {
    System.out.println("BeforeEach 실행");
    userService = new UserService();
  }

  @Test
  void createUser_shouldReturnName() {
    String result = userService.create("kim");

    assertEquals("kim", result);
    System.out.println("createUser_shouldReturnName 실행");
  }

  @Test
  void createUser_shouldNotReturnNull() {
    String result = userService.create("lee");

    assertNotNull(result);
    System.out.println("createUser_shouldNotReturnNull 실행");
  }
  @BeforeAll
  static void connectToDatabase() {
    System.out.println("테스트 DB 연결 시작");
  }

  @AfterAll
  static void disconnectFromDatabase() {
    System.out.println("테스트 DB 연결 해제");
  }
}

