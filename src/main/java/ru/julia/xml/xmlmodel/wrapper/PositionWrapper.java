package ru.julia.xml.xmlmodel.wrapper;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import ru.julia.xml.xmlmodel.PositionXml;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class PositionWrapper {
    @XmlElementWrapper(name = "positions")
    @XmlElement(name = "position")
    List<PositionXml> positions = new ArrayList<>();
}
