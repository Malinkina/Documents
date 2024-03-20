package ru.julia.xml.xmlmodel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

/**
 * Класс описывает должность
 */
@XmlRootElement
@JsonAutoDetect
@XmlAccessorType(XmlAccessType.FIELD)
public class PositionXml {
    @XmlElement
    private UUID id;
    @XmlElement
    private Integer positionId;
    @XmlElement
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
