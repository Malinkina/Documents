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
public class EmployeeXML {
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

    public UUID getPositionId() {
        return positionId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}

