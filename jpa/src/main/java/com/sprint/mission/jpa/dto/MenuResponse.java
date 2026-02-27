package com.sprint.mission.jpa.dto;

public record MenuResponse(
    Long id,
    String name,
    int price,
    String categoryName
) {}