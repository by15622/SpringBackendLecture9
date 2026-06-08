package org.example.springwebsocketdemo.controller;

import org.example.springwebsocketdemo.dto.TextMessageRequest;
import org.example.springwebsocketdemo.dto.TextMessageResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;

@Controller
public class MessageController {

  @MessageMapping("/message")
  @SendTo("/topic/messages")
  public TextMessageResponse sendMessage(
      @Payload TextMessageRequest request
  ) {

    System.out.println(
        "[" + LocalTime.now().withNano(0)
            + "] [MessageController] "
            + "sender=" + request.getSender()
            + ", content=" + request.getContent()
    );

    return new TextMessageResponse(
        request.getSender(),
        request.getContent(),
        LocalTime.now().withNano(0).toString()
    );
  }
}
