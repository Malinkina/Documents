package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PositionRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String name;
}
