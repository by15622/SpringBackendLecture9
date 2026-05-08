package com.sprint.mission.springstablehigh.ex3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberRepository memberRepository;

  @PostMapping
  public Member create(@RequestParam String name) {
    return memberRepository.save(
        Member.builder()
            .name(name)
            .build()
    );
  }

  @GetMapping("/count")
  public long count() {
    return memberRepository.count();
  }
}
