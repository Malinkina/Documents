package ru.julia.domain;

import lombok.Data;

import java.util.List;
@Data
public class Department {
    private String id;
    private String fullName;
    private String shortName;
    private String manager;
    private String organizationId;
    private List<String> contactPhoneNumbers;

}
