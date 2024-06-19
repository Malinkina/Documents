package ru.julia.domain;

public class Employee {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private String dateOfBirth;
    private String phoneNumber;
    private String positionId;
    private String departmentId;
    private String organizationId;

    public String getId() {
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

    public String getPositionId() {
        return positionId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
