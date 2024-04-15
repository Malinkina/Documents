package ru.julia.servicelayer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> phoneNumbers;
    private UUID organizationId;
}
