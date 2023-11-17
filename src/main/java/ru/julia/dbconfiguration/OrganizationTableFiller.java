package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.staff.Organization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class OrganizationTableFiller {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void fillOrganization(List<Organization> orgList) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            for (Organization organization : orgList) {
                String query = "INSERT INTO organization (id, full_name, short_name, manager) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, organization.getId());
                preparedStatement.setString(2, organization.getFullName());
                preparedStatement.setString(3, organization.getShortName());
                preparedStatement.setString(4, organization.getManager());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}