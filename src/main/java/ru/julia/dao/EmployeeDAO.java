package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.Employee;

import java.sql.*;

@Component
public class EmployeeDAO implements MyDAO<Employee> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Override
    public Employee getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employee WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Employee employee = new Employee();
            employee.setId(resultSet.getString("id"));
            employee.setSurname(resultSet.getString("surname"));
            employee.setName(resultSet.getString("name"));
            employee.setPatronymic(resultSet.getString("patronymic"));
            employee.setPhoto(resultSet.getString("photo"));
            employee.setDateOfBirth(resultSet.getString("date_of_birth"));
            employee.setPhoneNumber(resultSet.getString("phone_number"));
            employee.setDepartmentId(resultSet.getString("department_id"));
            employee.setOrganizationId(resultSet.getString("organization_id"));
            employee.setPositionId(resultSet.getString("position_id"));
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
