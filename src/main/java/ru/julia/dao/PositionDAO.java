package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.Position;

import java.sql.*;

@Component
public class PositionDAO implements MyDAO<Position> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Override
    public Position getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM position WHERE id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Position position = new Position();
            position.setId(resultSet.getString("id"));
            position.setId(resultSet.getString("position_id"));
            position.setName(resultSet.getString("name"));
            return position;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
