package ru.julia.service.modelforservice;

import java.util.List;
import java.util.UUID;

public class OrganizationModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private List<String> phoneNumbers;

    private OrganizationModel() {
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getManager() {
        return manager;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public static class OrganizationModelBuilder {
        private final OrganizationModel organizationModel = new OrganizationModel();

        public OrganizationModelBuilder id(UUID id) {
            organizationModel.id = id;
            return this;
        }

        public OrganizationModelBuilder fullName(String fullName) {
            organizationModel.fullName = fullName;
            return this;
        }
        public OrganizationModelBuilder shortName(String shortName) {
            organizationModel.shortName = shortName;
            return this;
        }

        public OrganizationModelBuilder manager(String manager) {
            organizationModel.manager = manager;
            return this;
        }
        public OrganizationModelBuilder phoneNumbers(List<String> phoneNumbers) {
            organizationModel.phoneNumbers = phoneNumbers;
            return this;
        }
        public OrganizationModel build() {
            return organizationModel;
        }
    }
}
