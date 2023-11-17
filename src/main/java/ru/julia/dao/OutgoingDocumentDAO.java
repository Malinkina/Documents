package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.OutgoingDocument;

import java.sql.*;

@Component
public class OutgoingDocumentDAO extends DocumentDAO<OutgoingDocument> implements MyDAO<OutgoingDocument> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Override
    public OutgoingDocument getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM outgoing_document " +
                            "JOIN document d on outgoing_document.document_id = d.id " +
                            "WHERE outgoing_document.id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            OutgoingDocument outgoingDocument = new OutgoingDocument();
            outgoingDocument.setDeliveryType(resultSet.getString("delivery_type"));
            outgoingDocument.setRecipientId(resultSet.getString("delivery_type"));
            return fill(outgoingDocument, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
