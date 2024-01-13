package ru.julia.domain;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private String dateOfBirth;
    private String phoneNumber;
    private String positionId;
    private String departmentId;
    private String organizationId;
}
