package com.sprint.mission.springhello.controller;

import com.sprint.mission.springhello.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // = @Controller + @ResponseBody (반환값을 JSON으로)
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        // DB 대신 임시 데이터 반환 (실습용)
        return new UserDto(id, "Kim", 27);
    }
}