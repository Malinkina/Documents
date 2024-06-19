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
    private Position position;
    @XmlElement
    private Department department;
    @XmlElement
    private Organization organization;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Organization getOrganization() {
        return organization;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}
