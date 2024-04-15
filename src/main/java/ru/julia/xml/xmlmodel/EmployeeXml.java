package ru.julia.xml.xmlmodel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.UUID;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXml {
    @XmlElement
    private UUID id;
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
    private UUID positionId;
    @XmlElement
    private UUID departmentId;
    @XmlElement
    private UUID organizationId;
}

