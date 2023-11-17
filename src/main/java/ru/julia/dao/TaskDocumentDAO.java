package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.TaskDocument;

import java.sql.*;

@Component
public class TaskDocumentDAO extends DocumentDAO<TaskDocument> implements MyDAO<TaskDocument> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Override
    public TaskDocument getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM task_document " +
                            "JOIN document d on task_document.document_id = d.id " +
                            "WHERE task_document.id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            TaskDocument taskDocument = new TaskDocument();
            taskDocument.setIssueDate(resultSet.getString("issue_date"));
            taskDocument.setExecutionTerm(resultSet.getString("execution_term"));
            taskDocument.setControlMark(resultSet.getBoolean("control_mark"));
            taskDocument.setResponsibleExecutiveId(resultSet.getString("responsible_executive_id"));
            taskDocument.setControllerId(resultSet.getString("controller_id"));
            return fill(taskDocument, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
