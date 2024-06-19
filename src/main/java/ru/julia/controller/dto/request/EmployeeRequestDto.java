package ru.julia.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class EmployeeRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String surname;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String name;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String patronymic;
    private String photo;
    @Past
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private String phoneNumber;
    @NotNull
    private UUID departmentId;
    @NotNull
    private UUID organizationId;
    @NotNull
    private UUID positionId;

    public EmployeeRequestDto() {
    }

    public EmployeeRequestDto(String surname,
                              String name,
                              String patronymic,
                              String photo,
                              LocalDate dateOfBirth,
                              String phoneNumber,
                              UUID departmentId,
                              UUID organizationId,
                              UUID positionId) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.photo = photo;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
        this.organizationId = organizationId;
        this.positionId = positionId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public UUID getPositionId() {
        return positionId;
    }

    public void setPositionId(UUID positionId) {
        this.positionId = positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeRequestDto that = (EmployeeRequestDto) o;

        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(patronymic, that.patronymic)) return false;
        if (!Objects.equals(photo, that.photo)) return false;
        if (!Objects.equals(dateOfBirth, that.dateOfBirth)) return false;
        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        if (!Objects.equals(departmentId, that.departmentId)) return false;
        if (!Objects.equals(organizationId, that.organizationId))
            return false;
        return Objects.equals(positionId, that.positionId);
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        return result;
    }
}
