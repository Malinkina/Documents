package ru.julia.staff;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс описывает должность
 */
@XmlRootElement
@JsonAutoDetect
@XmlAccessorType(XmlAccessType.FIELD)
public class Position {
    @XmlElement
    private String id;
    @XmlElement
    private int positionId;
    @XmlElement
    private String name;

    public String getId() {
        return id;
    }

    public int getPositionId() {
        return positionId;
    }

    public String getName() {
        return name;
    }
}
