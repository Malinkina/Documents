package ru.julia.staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person extends Staff implements Comparable<Person> {
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
    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public int compareTo(Person person) {
        return this.surname.compareTo(person.surname);
    }
}
