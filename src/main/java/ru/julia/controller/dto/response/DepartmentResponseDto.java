package ru.julia.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> phoneNumbers;
    private UUID organizationId;
}
