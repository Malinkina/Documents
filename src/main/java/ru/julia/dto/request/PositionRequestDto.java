package ru.julia.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PositionRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
