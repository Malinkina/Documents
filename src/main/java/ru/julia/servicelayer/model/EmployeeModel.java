package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@NoArgsConstructor
public class EmployeeModel {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private UUID departmentId;
    private UUID organizationId;
    private UUID positionId;
}
