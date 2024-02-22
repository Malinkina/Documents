package ru.julia.service.modelforservice;

import java.util.List;
import java.util.UUID;

public class OrganizationModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> contactPhoneNumber;

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

    public List<String> getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(List<String> contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
