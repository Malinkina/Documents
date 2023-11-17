package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.staff.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class DepartmentTableFiller {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    public void fillDepartment(List<Department> departmentList) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            for (Department department : departmentList) {
                String query = "INSERT INTO department (id, full_name, short_name, manager, organization_id) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, department.getId());
                preparedStatement.setString(2, department.getFullName());
                preparedStatement.setString(3, department.getShortName());
                preparedStatement.setString(4, department.getManager());
                preparedStatement.setString(5, department.getOrganizationId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}