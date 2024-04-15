package ru.julia.controller.dto.response;

import lombok.Data;

import java.util.UUID;
@Data
public class PositionResponseDto {
    private UUID id;
    private String name;
    private int positionId;
}
