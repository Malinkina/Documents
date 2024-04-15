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
public class PositionXml {
    @XmlElement
    private UUID id;
    @XmlElement
    private Integer positionId;
    @XmlElement
    private String name;
}
