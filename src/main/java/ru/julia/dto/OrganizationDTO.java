package ru.julia.dto;

import ru.julia.staff.Employee;

import java.util.List;

public class OrganizationDTO {
    private String fullName;
    private String shortName;
    private Employee manager;
    private List<String> contactPhoneNumbers;
}
