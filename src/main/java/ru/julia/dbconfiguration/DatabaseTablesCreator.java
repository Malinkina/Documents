package ru.julia.dbconfiguration;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
@Component
public class DatabaseTablesCreator {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    public void createTables() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            String[] split = FileUtils.readFileToString(new File("src/main/resources/init.sql")).split(";");
            for (String query : split) {
                statement.execute(query);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}