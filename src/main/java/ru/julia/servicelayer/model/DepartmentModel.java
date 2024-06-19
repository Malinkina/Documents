package ru.julia.servicelayer.model;

import java.util.List;
import java.util.UUID;

public class DepartmentModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private UUID organizationId;
    private List<String> phoneNumbers;

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

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentModel model = (DepartmentModel) o;

        if (!Objects.equals(id, model.id)) return false;
        if (!Objects.equals(fullName, model.fullName)) return false;
        if (!Objects.equals(shortName, model.shortName)) return false;
        if (!Objects.equals(manager, model.manager)) return false;
        if (!Objects.equals(organizationId, model.organizationId))
            return false;
        return Objects.equals(phoneNumbers, model.phoneNumbers);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (phoneNumbers != null ? phoneNumbers.hashCode() : 0);
        return result;
    }*/
}
