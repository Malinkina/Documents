package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;
@Data
public abstract class DocumentRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String name;
    @NotNull
    private String text;
}
