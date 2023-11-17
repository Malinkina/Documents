package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.Organization;

import java.sql.*;

@Component
public class OrganizationDAO implements MyDAO<Organization>{
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Override
    public Organization getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organization WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Organization organization = new Organization();
            organization.setId(resultSet.getString("id"));
            organization.setFullName(resultSet.getString("full_name"));
            organization.setShortName(resultSet.getString("short_name"));
            organization.setManager(resultSet.getString("manager"));
            return organization;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
