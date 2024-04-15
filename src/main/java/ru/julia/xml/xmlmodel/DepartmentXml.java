package ru.julia.xml.xmlmodel;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentXml {
    @XmlElement
    private UUID id;
    @XmlElement
    private String fullName;
    @XmlElement
    private String shortName;
    @XmlElement
    private String manager;
    @XmlElement
    private UUID organizationId;
    @XmlElementWrapper(name = "phoneNumbers")
    @XmlElement(name = "phoneNumber")
    private List<String> phoneNumbers;
}
