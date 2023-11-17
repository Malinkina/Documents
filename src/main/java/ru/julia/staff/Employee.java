package ru.julia.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс описывает персонал
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends Staff {
    @XmlElement
    private String id;
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
    private String positionId;
    @XmlElement
    private String departmentId;
    @XmlElement
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

    public String getOrganizationId() {
        return organizationId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}
