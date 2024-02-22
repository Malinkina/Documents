package ru.julia.service.modelforservice;

import java.util.UUID;

public class DepartmentModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private String organizationId;
    private String contactPhoneNumbers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }

    public void setContactPhoneNumbers(String contactPhoneNumbers) {
        this.contactPhoneNumbers = contactPhoneNumbers;
    }
}
