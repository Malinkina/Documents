package ru.julia.dbconfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DBInitiation {
    public void initialize() {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:test; create = true")) {
            Statement statement = connection.createStatement();
            List<String> tables = Arrays.asList(
                    "CREATE TABLE IF NOT EXISTS documents (id INT primary key, doc_id INT, name varchar(255), text varchar(255), " +
                                                        "regNumber varchar(255), regDate date, author INT foreign key)",
                    "CREATE TABLE IF NOT EXISTS employees (id INT primary key, surname varchar(255), name varchar(255), " +
                                                        "patronymic varchar(255), position INT foreign key, photo varchar(255)" +
                                                        "date_of_birth varchar(255), phone_number varchar(255), " +
                                                        "department INT foreign key, organization INT foreign key)",
                    "CREATE TABLE IF NOT EXISTS positions (id INT primary key, position_id INT, name varchar(255))",
                    "CREATE TABLE IF NOT EXISTS departments (id INT primary key, full_name varchar(255), short_name varchar(255)," +
                                                            " manager varchar(255), contact_phone_numbers )",
                    "CREATE TABLE IF NOT EXISTS organizations (id INT primary key, full_name varchar(255), short_name varchar(255), manager varchar(255)))",
                    "CREATE TABLE IF NOT EXISTS incoming_documents (id INT primary key, sender INT foreign key, recipient INT foreign key, " +
                                                                "outgoing_number INT, outgoing_reg_date varchar(255))",
                    "CREATE TABLE IF NOT EXISTS outgoing_documents (id INT primary key, recipient INT foreign key, delivery_type varchar(255))",
                    "CREATE TABLE IF NOT EXISTS task_documents (id INT primary key, responsible_executive INT foreign key, issue_date varchar(255), " +
                                                            "execution_term varchar(255), control_mark boolean, controller INT foreign key)"
            );
            for (String table : tables) {
                statement.execute(table);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
