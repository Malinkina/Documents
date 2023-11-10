package ru.julia.staff;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Класс описывает подразделение
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Department extends Staff {
    @XmlElement
    private String id;
    @XmlElement
    private String fullName;
    @XmlElement
    private String shortName;
    @XmlElement
    private String manager;
    @XmlElement
    private String organizationId;
    @XmlElementWrapper(name = "contactPhoneNumbers")
    @XmlElement(name = "contactPhoneNumber")
    private List<String> contactPhoneNumbers;

    public String getOrganizationId() {
        return organizationId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getManager() {
        return manager;
    }

    public String getId() {
        return id;
    }

    public List<String> getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }
}
