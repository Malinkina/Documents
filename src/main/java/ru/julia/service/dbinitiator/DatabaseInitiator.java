package ru.julia.service.dbinitiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dbconfiguration.DepartmentTableFiller;
import ru.julia.dbconfiguration.EmployeeTableFiller;
import ru.julia.dbconfiguration.OrganizationTableFiller;
import ru.julia.dbconfiguration.PositionTableFiller;
import ru.julia.xml.XMLReader;

@Component
public class DatabaseInitiator {
    @Autowired
    XMLReader xmlReader;
    @Autowired
    private OrganizationTableFiller organizationTableFiller;
    @Autowired
    private DepartmentTableFiller departmentTableFiller;
    @Autowired
    private PositionTableFiller positionTableFiller;
    @Autowired
    private EmployeeTableFiller employeeTableFiller;
    public void initialize() {
        organizationTableFiller.fillOrganization();
        departmentTableFiller.fillDepartment();
        positionTableFiller.fillPosition();
        employeeTableFiller.fillEmployee();
    }
}
