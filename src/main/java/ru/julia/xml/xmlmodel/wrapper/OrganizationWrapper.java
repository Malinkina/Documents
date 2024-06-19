package ru.julia.xml.xmlmodel.wrapper;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import ru.julia.xml.xmlmodel.OrganizationXml;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationWrapper {
    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    List<OrganizationXml> organizations = new ArrayList<>();
}
