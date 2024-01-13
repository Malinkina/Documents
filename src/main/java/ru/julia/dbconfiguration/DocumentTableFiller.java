package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.document.IncomingDocument;
import ru.julia.document.OutgoingDocument;
import ru.julia.document.TaskDocument;

import java.sql.*;
import java.util.List;
import java.util.UUID;
@Component
public class DocumentTableFiller {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    public void fillDocumentTables(List<Document> documents) {
        for (Document document : documents) {
            String documentPrimaryKey = fillDocumentDefaultInfo(document);
            if (document instanceof IncomingDocument) {
                fillIncDocTable(document, documentPrimaryKey);
            } else if (document instanceof OutgoingDocument) {
                fillOutgoingDocTable(document, documentPrimaryKey);
            } else if (document instanceof TaskDocument) {
                fillTaskDocTable(document, documentPrimaryKey);
            }
        }
    }

    public String fillDocumentDefaultInfo(Document document) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO document (" +
                    "id, doc_id, name, text, reg_number, reg_date, author_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String primaryKey = String.valueOf(UUID.randomUUID());
            preparedStatement.setString(1, primaryKey);
            preparedStatement.setInt(2, document.getId());
            preparedStatement.setString(3, document.getName());
            preparedStatement.setString(4, document.getText());
            preparedStatement.setString(5, document.getRegNumber());
            preparedStatement.setDate(6, Date.valueOf(document.getRegDate()));
            preparedStatement.setString(7, document.getAuthor().getId());
            preparedStatement.executeUpdate();
            return primaryKey;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void fillIncDocTable(Document document, String primaryKey) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            IncomingDocument incomingDocument = (IncomingDocument) document;
            String query = "INSERT INTO incoming_document (" +
                    "id, outgoing_number, outgoing_reg_date, recipient_id, sender_id, document_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setInt(2, incomingDocument.getOutgoingNumber());
            preparedStatement.setString(3, incomingDocument.getOutgoingRegDate());
            preparedStatement.setString(4, incomingDocument.getRecipient().getId());
            preparedStatement.setString(5, incomingDocument.getSender().getId());
            preparedStatement.setString(6, primaryKey);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void fillOutgoingDocTable(Document document, String primaryKey) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            OutgoingDocument outgoingDocument = (OutgoingDocument) document;
            String query = "INSERT INTO outgoing_document (" +
                    "id, delivery_type, recipient_id, document_id" +
                    ") VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, outgoingDocument.getDeliveryType());
            preparedStatement.setString(3, outgoingDocument.getRecipient().getId());
            preparedStatement.setString(4, primaryKey);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void fillTaskDocTable(Document document, String primaryKey) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            TaskDocument taskDocument = (TaskDocument) document;
            String query = "INSERT INTO task_document (" +
                    "id, issue_date, execution_term, control_mark, responsible_executive_id, " +
                    "controller_id, document_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, taskDocument.getIssueDate());
            preparedStatement.setString(3, taskDocument.getExecutionTerm());
            preparedStatement.setBoolean(4, taskDocument.isControlMark());
            preparedStatement.setString(5, taskDocument.getResponsibleExecutive().getId());
            preparedStatement.setString(6, taskDocument.getController().getId());
            preparedStatement.setString(7, primaryKey);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
