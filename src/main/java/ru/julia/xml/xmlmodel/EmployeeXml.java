package ru.julia.xml.xmlmodel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

/**
 * Класс описывает персонал
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXml {
    @XmlElement
    private UUID id;
    @XmlElement
    private String surname;
    @XmlElement
    private String name;
    @XmlElement
    private String patronymic;
    @XmlElement
    private String photo;
    @XmlElement
    private String dateOfBirth;
    @XmlElement
    private String phoneNumber;
    @XmlElement
    private UUID positionId;
    @XmlElement
    private UUID departmentId;
    @XmlElement
    private UUID organizationId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getPositionId() {
        return positionId;
    }

    public void setPositionId(UUID positionId) {
        this.positionId = positionId;
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
}

