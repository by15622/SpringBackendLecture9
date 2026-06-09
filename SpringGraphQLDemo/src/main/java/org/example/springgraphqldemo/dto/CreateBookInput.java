package org.example.springgraphqldemo.dto;

public record CreateBookInput(
    String title,
    String author,
    Integer price
) {
}
