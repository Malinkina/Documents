package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;
@Data
public class OrganizationRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String fullName;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String shortName;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String manager;
    @NotNull
    private List<String> phoneNumbers;
}
