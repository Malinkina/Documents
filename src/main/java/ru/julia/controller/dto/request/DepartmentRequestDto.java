package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDto {
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
    @NotNull
    private UUID organizationId;

}
