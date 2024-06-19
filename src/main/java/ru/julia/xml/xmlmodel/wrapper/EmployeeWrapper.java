package ru.julia.xml.xmlmodel.wrapper;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeWrapper {
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    List<EmployeeXml> employees = new ArrayList<>();
}
