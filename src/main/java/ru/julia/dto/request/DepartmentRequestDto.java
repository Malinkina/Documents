package ru.julia.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.UUID;

public class DepartmentRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String fullName;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String shortName;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String manager;
    @NotNull
    private List<String> phoneNumbers;
    @NotNull
    private UUID organizationId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }
}
