package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PositionModel {
    private UUID id;
    private Integer positionId;
    private String name;
}
