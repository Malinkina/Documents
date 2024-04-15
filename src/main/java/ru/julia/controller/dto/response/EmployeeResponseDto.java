package ru.julia.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private UUID organizationId;
    private UUID departmentId;
    private UUID positionId;
}
