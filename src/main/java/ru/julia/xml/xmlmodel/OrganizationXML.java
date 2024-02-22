package ru.julia.xml.xmlmodel;

import jakarta.xml.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationXML {
    @XmlElement
    private UUID id;
    @XmlElement
    private String fullName;
    @XmlElement
    private String shortName;
    @XmlElement
    private String manager;
    @XmlElementWrapper(name = "contactPhoneNumbers")
    @XmlElement(name = "contactPhoneNumber")
    private List<String> contactPhoneNumbers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<String> getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }

    public void setContactPhoneNumbers(List<String> contactPhoneNumbers) {
        this.contactPhoneNumbers = contactPhoneNumbers;
    }
}

