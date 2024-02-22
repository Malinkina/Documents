package ru.julia.service.modelforservice;

import java.util.UUID;

public class DepartmentModel {
    private UUID id;
    private String fullName;
    private String shortName;
    private String manager;
    private UUID organizationId;
    private String phoneNumbers;

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

    public String getPhoneNumbers() {
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
        public DepartmentModelBuilder phoneNumbers(String phoneNumbers) {
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
