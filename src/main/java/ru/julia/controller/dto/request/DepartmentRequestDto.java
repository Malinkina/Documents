package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Objects;
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

    public DepartmentRequestDto() {
    }

    public DepartmentRequestDto(String fullName, String shortName, String manager, List<String> phoneNumbers, UUID organizationId) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.manager = manager;
        this.phoneNumbers = phoneNumbers;
        this.organizationId = organizationId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentRequestDto that = (DepartmentRequestDto) o;

        if (!Objects.equals(fullName, that.fullName)) return false;
        if (!Objects.equals(shortName, that.shortName)) return false;
        if (!Objects.equals(manager, that.manager)) return false;
        if (!Objects.equals(phoneNumbers, that.phoneNumbers)) return false;
        return Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (phoneNumbers != null ? phoneNumbers.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        return result;
    }
}
