package com.sprint.mission.springsecuritysessionmanagementcore.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticationInfoResponse {

  private String username;

  private String authenticationClass;

  private String principalClass;

  private boolean authenticated;

  private List<String> authorities;

  private String sessionId;

  private String threadName;

}
