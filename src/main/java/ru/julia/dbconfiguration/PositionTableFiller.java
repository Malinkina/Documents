package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.staff.Position;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class PositionTableFiller {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    public void fillPosition(List<Position> positionList) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            for (Position position : positionList) {
                String query = "INSERT INTO position (id, position_id, name) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, position.getId());
                preparedStatement.setInt(2, position.getPositionId());
                preparedStatement.setString(3, position.getName());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}