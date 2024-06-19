package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.staff.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeTableFiller {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void fillEmployee(List<Employee> employeeList) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            for (Employee employee : employeeList) {
                String query = "INSERT INTO employee (id, surname, name, patronymic, photo, date_of_birth," +
                        " phone_number,position_id, department_id, organization_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, employee.getId());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getName());
                preparedStatement.setString(4, employee.getPatronymic());
                preparedStatement.setString(5, employee.getPhoto());
                preparedStatement.setString(6, employee.getDateOfBirth());
                preparedStatement.setString(7, employee.getPhoneNumber());
                preparedStatement.setString(8, employee.getPositionId());
                preparedStatement.setString(9, employee.getDepartmentId());
                preparedStatement.setString(10, employee.getOrganizationId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}