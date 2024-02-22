/*
package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.orm.domain.JPADepartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DepartmentDAO implements MyDAO<JPADepartment> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void create(JPADepartment department) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO department VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, department.getFullName());
            preparedStatement.setString(3, department.getShortName());
            preparedStatement.setString(4, department.getManager());
            preparedStatement.setString(5, department.getOrganizationId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JPADepartment read(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM department WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            JPADepartment department = new JPADepartment();
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

    @Override
    public List<JPADepartment> readAll() {
        List<JPADepartment> departments = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM department"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.isLast()) {
                resultSet.next();
                JPADepartment department = new JPADepartment();
                department.setId(resultSet.getString("id"));
                department.setFullName(resultSet.getString("full_name"));
                department.setShortName(resultSet.getString("short_name"));
                department.setManager(resultSet.getString("manager"));
                department.setOrganizationId(resultSet.getString("organization_id"));
                departments.add(department);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public void update(String id, JPADepartment department) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE department SET full_name = ?, short_name = ? " +
                            "WHERE id = ?"
            );
            if (department.getFullName() != null && department.getShortName() != null) {
                preparedStatement.setString(1, department.getFullName());
                preparedStatement.setString(2, department.getShortName());
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
                    "DELETE FROM department WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
*/
