package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.IncomingDocument;

import java.sql.*;

@Component
public class IncomingDocumentDAO extends DocumentDAO<IncomingDocument> implements MyDAO<IncomingDocument> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public IncomingDocument getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM incoming_document " +
                            "JOIN document d on incoming_document.document_id = d.id " +
                            "WHERE incoming_document.id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            IncomingDocument incomingDocument = new IncomingDocument();
            incomingDocument.setSenderId(resultSet.getString("sender_id"));
            incomingDocument.setRecipientId(resultSet.getString("recipient_id"));
            incomingDocument.setOutgoingNumber(resultSet.getInt("outgoing_number"));
            incomingDocument.setOutgoingRegDate(resultSet.getString("outgoing_reg_date"));
            return fill(incomingDocument, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
