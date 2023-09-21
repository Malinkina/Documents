package ru.julia.staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает подразделение
 */
@XmlRootElement
public class Department extends Staff {
    @XmlElement
    private String fullName;
    @XmlElement
    private String shortName;
    @XmlElement
    private Person manager;
    @XmlElementWrapper
    @XmlElement(name = "contactPhoneNumber")
    private final List<String> contactPhoneNumbers = new ArrayList<>();

    public void setManager(Person manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", manager='" + manager + '\'' +
                ", contactPhoneNumbers=" + contactPhoneNumbers +
                '}';
    }
}
