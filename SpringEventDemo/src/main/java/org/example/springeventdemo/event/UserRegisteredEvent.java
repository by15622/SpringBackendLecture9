package org.example.springeventdemo.event;

public record UserRegisteredEvent(
        String userId,
        String email
) {

}
