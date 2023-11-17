package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.Department;

import java.sql.*;

@Component
public class DepartmentDAO implements MyDAO<Department> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Override
    public Department getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM department WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Department department = new Department();
            department.setId(resultSet.getString("id"));
            department.setFullName(resultSet.getString("full_name"));
            department.setShortName(resultSet.getString("short_name"));
            department.setManager(resultSet.getString("manager"));
            department.setOrganizationId(resultSet.getString("organization_id"));
            return department;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
