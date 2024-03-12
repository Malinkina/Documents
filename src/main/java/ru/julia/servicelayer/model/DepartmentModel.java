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

    private DepartmentModel() {}

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

    public UUID getOrganizationId() {
        return organizationId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    public static class DepartmentModelBuilder {
        private DepartmentModel departmentModel = new DepartmentModel();
        public DepartmentModelBuilder id(UUID id) {
            departmentModel.id = id;
            return this;
        }

        public DepartmentModelBuilder fullName(String fullName) {
            departmentModel.fullName = fullName;
            return this;
        }

        public DepartmentModelBuilder shortName(String shortName) {
            departmentModel.shortName = shortName;
            return this;
        }
        public DepartmentModelBuilder manager(String manager) {
            departmentModel.manager = manager;
            return this;
        }
        public DepartmentModelBuilder phoneNumbers(List<String> phoneNumbers) {
            departmentModel.phoneNumbers = phoneNumbers;
            return this;
        }
        public DepartmentModelBuilder organizationId(UUID id) {
            departmentModel.organizationId = id;
            return this;
        }
        public DepartmentModel build() {
            return departmentModel;
        }
    }
}
