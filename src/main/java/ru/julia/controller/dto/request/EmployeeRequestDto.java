package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String surname;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String name;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String patronymic;
    private String photo;
    @Past
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private String phoneNumber;
    @NotNull
    private UUID departmentId;
    @NotNull
    private UUID organizationId;
    @NotNull
    private UUID positionId;
}
