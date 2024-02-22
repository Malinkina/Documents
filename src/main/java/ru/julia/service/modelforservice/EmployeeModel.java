package ru.julia.service.modelforservice;

import java.util.UUID;

public class EmployeeModel {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private String dateOfBirth;
    private String phoneNumber;
    private UUID departmentId;
    private UUID organizationId;
    private UUID positionId;

    private EmployeeModel() {
    }

    public UUID getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public UUID getPositionId() {
        return positionId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public void setPositionId(UUID positionId) {
        this.positionId = positionId;
    }

    public static class EmployeeModelBuilder {
        private EmployeeModel employeeModel = new EmployeeModel();

        public EmployeeModelBuilder id(UUID id) {
            employeeModel.id = id;
            return this;
        }
        public EmployeeModelBuilder surname(String surname) {
            employeeModel.surname = surname;
            return this;
        }
        public EmployeeModelBuilder name(String name) {
            employeeModel.name = name;
            return this;
        }
        public EmployeeModelBuilder patronymic(String patronymic) {
            employeeModel.patronymic = patronymic;
            return this;
        }
        public EmployeeModelBuilder photo(String photo) {
            employeeModel.photo = photo;
            return this;
        }
        public EmployeeModelBuilder dateOfBirth(String dateOfBirth) {
            employeeModel.dateOfBirth = dateOfBirth;
            return this;
        }
        public EmployeeModelBuilder phoneNumber(String phoneNumber) {
            employeeModel.phoneNumber = phoneNumber;
            return this;
        }
        public EmployeeModelBuilder organizationId(UUID id) {
            employeeModel.organizationId = id;
            return this;
        }
        public EmployeeModelBuilder departmentId(UUID id) {
            employeeModel.departmentId = id;
            return this;
        }
        public EmployeeModelBuilder positionId(UUID id) {
            employeeModel.positionId = id;
            return this;
        }
        public EmployeeModel build() {
            return employeeModel;
        }
    }
}
