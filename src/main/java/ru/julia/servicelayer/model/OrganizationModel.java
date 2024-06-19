package ru.julia.servicelayer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class OrganizationModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> phoneNumbers;
}
