package ru.julia.controller.dto.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class OrganizationResponseDto {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> phoneNumbers;
}
