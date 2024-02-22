/*
package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.orm.domain.JPAOrganization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class OrganizationDAO implements MyDAO<JPAOrganization> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void create(JPAOrganization organization) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO organization VALUES (?, ?, ?, ?)"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, organization.getFullName());
            preparedStatement.setString(3, organization.getShortName());
            preparedStatement.setString(4, organization.getManager());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JPAOrganization read(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organization WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            JPAOrganization organization = new JPAOrganization();
            organization.setId(resultSet.getString("id"));
            organization.setFullName(resultSet.getString("full_name"));
            organization.setShortName(resultSet.getString("short_name"));
            organization.setManager(resultSet.getString("manager"));
            return organization;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<JPAOrganization> readAll() {
        List<JPAOrganization> orgs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organization"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.isLast()) {
                resultSet.next();
                JPAOrganization organization = new JPAOrganization();
                organization.setId(resultSet.getString("id"));
                organization.setFullName(resultSet.getString("full_name"));
                organization.setShortName(resultSet.getString("short_name"));
                organization.setManager(resultSet.getString("manager"));
                orgs.add(organization);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orgs;
    }

    public void update(String id, JPAOrganization organization) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE organization SET full_name = ?, short_name = ? WHERE id = ?"
            );
            if (organization.getFullName() != null && organization.getShortName() != null) {
                preparedStatement.setString(1, organization.getFullName());
                preparedStatement.setString(2, organization.getShortName());
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
                    "DELETE FROM organization WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
