package ru.julia.staff;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс описывает персонал
 */
@XmlRootElement
@JsonAutoDetect
public class Person extends Staff {
    @XmlElement
    private String surname;
    @XmlElement
    private String name;
    @XmlElement
    private String patronymic;
    @XmlElement
    private String position;
    @XmlElement
    private String photo;
    @XmlElement
    private String dateOfBirth;
    @XmlElement
    private String phoneNumber;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPosition() {
        return position;
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

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}
