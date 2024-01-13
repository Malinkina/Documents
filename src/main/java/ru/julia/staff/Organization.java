package ru.julia.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Класс описывает организацию
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization extends Staff {
    @XmlElement
    private String id;
    @XmlElement
    private String fullName;
    @XmlElement
    private String shortName;
    @XmlElement
    private String manager;
    @XmlElementWrapper(name = "contactPhoneNumbers")
    @XmlElement(name = "contactPhoneNumber")
    private List<String> contactPhoneNumbers;

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getManager() {
        return manager;
    }

    public List<String> getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }

    public String getId() {
        return id;
    }

    public void setContactPhoneNumbers(List<String> contactPhoneNumbers) {
        this.contactPhoneNumbers = contactPhoneNumbers;
    }
}
