package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.XMLReader;

@Component
public class DatabaseInitiator {
    @Autowired
    XMLReader xmlReader;
    @Autowired
    private DatabaseTablesCreator dbTablesCreation;
    @Autowired
    private OrganizationTableFiller organizationTableFiller;
    @Autowired
    private DepartmentTableFiller departmentTableFiller;
    @Autowired
    private PositionTableFiller positionTableFiller;
    @Autowired
    private EmployeeTableFiller employeeTableFiller;
    public void initialize() {
        dbTablesCreation.createTables();
        organizationTableFiller.fillOrganization(xmlReader.readOrganization().getOrgList());
        departmentTableFiller.fillDepartment(xmlReader.readDepartment().getDepartmentList());
        positionTableFiller.fillPosition(xmlReader.readPosition().getPositionList());
        employeeTableFiller.fillEmployee(xmlReader.readEmployee().getEmployeeList());
    }
}
