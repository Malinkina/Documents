package ru.julia.dbconfiguration;

import ru.julia.XMLReader;
import ru.julia.staff.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInsertionIntoDepartmentTable {
    private XMLReader xmlReader;
    public void insertDepartment() {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:test")) {
            int i = 1;
            for (Department department : xmlReader.readDepartment().getDepartmentList()) {
                String query = "INSERT INTO departments (id, full_name, short_name, manager) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, department.getFullName());
                preparedStatement.setString(3, department.getShortName());
                preparedStatement.setString(4, department.getManager());
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
