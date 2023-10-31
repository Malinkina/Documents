package ru.julia.dbconfiguration;

import ru.julia.XMLReader;
import ru.julia.staff.Organization;

import java.sql.*;

public class DBInsertionIntoOrganizationTable {
    private XMLReader xmlReader = new XMLReader();

    public void insertOrganization() {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:test")) {
            int i = 1;
            for (Organization organization : xmlReader.readOrganization().getOrgList()) {
                String query = "INSERT INTO organizations (id, full_name, short_name, manager) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, organization.getFullName());
                preparedStatement.setString(3, organization.getShortName());
                preparedStatement.setString(4, organization.getManager());
                preparedStatement.executeUpdate();
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

