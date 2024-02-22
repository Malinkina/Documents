/*
package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.orm.domain.JPAEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class EmployeeDAO implements MyDAO<JPAEmployee> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void create(JPAEmployee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getPatronymic());
            preparedStatement.setString(5, employee.getPhoto());
            preparedStatement.setString(6, employee.getDateOfBirth());
            preparedStatement.setString(7, employee.getPhoneNumber());
            preparedStatement.setString(8, employee.getDepartmentId());
            preparedStatement.setString(9, employee.getOrganizationId());
            preparedStatement.setString(10, employee.getPositionId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public JPAEmployee read(String id) {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = ?"
        );
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        JPAEmployee employee = new JPAEmployee();
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<JPAEmployee> readAll() {
        List<JPAEmployee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employee"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.isLast()) {
                resultSet.next();
                JPAEmployee employee = new JPAEmployee();
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
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
    public void update(String id, JPAEmployee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE employee SET name = ?, " +
                            "phone_number = ? WHERE id = ?"
            );
            if (employee.getName() != null && employee.getPhoneNumber() != null) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getPhoneNumber());
                preparedStatement.setString(3, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM employee WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
