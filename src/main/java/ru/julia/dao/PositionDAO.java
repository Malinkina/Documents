package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PositionDAO implements MyDAO<Position> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void create(Position position) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO position VALUES (?, ?, ?)"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setInt(2, position.getPositionId());
            preparedStatement.setString(3, position.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Position read(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM position WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Position position = new Position();
            position.setId(resultSet.getString("id"));
            position.setPositionId(resultSet.getInt("position_id"));
            position.setName(resultSet.getString("name"));
            return position;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Position> readAll() {
        List<Position> positions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM position"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.isLast()) {
                resultSet.next();
                Position position = new Position();
                position.setId(resultSet.getString("id"));
                position.setPositionId(resultSet.getInt("position_id"));
                position.setName(resultSet.getString("name"));
                positions.add(position);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positions;
    }

    public void update(String id, Position position) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE position SET name = ? WHERE id = ?"
            );
            if (position.getName() != null) {
                preparedStatement.setString(1, position.getName());
                preparedStatement.setString(2, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM position WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
