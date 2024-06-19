package ru.julia.xml.xmlmodel.wrapper;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import ru.julia.xml.xmlmodel.DepartmentXml;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentWrapper {
    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    List<DepartmentXml> departments = new ArrayList<>();
}
