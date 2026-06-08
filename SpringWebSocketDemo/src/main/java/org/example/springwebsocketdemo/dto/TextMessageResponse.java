package org.example.springwebsocketdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TextMessageResponse {

  private String sender;
  private String content;
  private String sentAt;
}