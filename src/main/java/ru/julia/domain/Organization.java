package ru.julia.domain;


import lombok.Data;

import java.util.List;
@Data
public class Organization {
    private String id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> contactPhoneNumbers;

}
