package ru.julia.xml.xmlmodel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Класс описывает должность
 */
@XmlRootElement
@JsonAutoDetect
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLPosition {
    @XmlElement
    private String id;
    @XmlElement
    private int positionId;
    @XmlElement
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
