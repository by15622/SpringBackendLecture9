package com.sprint.mission.springstablehigh.ex1;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final Set<String> emails = new HashSet<>();

  public void register(String email) {

    if (emails.contains(email)) {
      throw new DuplicateEmailException(email);
    }

    emails.add(email);
  }
}