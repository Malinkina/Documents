package ru.julia.staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Класс описывает организацию
 */
@XmlRootElement(name = "organization")
public class Organization extends Staff {
    @XmlElement
    private String fullName;
    @XmlElement
    private String shortName;
    @XmlElement
    private Person manager;
    @XmlElementWrapper(name = "contactPhoneNumbers")
    @XmlElement(name = "contactPhoneNumber")
    private List<String> contactPhoneNumbers;

    public void setManager(Person manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", manager='" + manager + '\'' +
                ", contactPhoneNumbers=" + contactPhoneNumbers +
                '}';
    }
}
