package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.documents.IncomingDocument;

import java.sql.*;

@Component
public class IncomingDocumentDAO implements MyDAO<IncomingDocument> {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public IncomingDocument getById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM document WHERE id = (SELECT document_id FROM incoming_document WHERE id = ?)"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            IncomingDocument.IncomingDocumentBuilder builder = new IncomingDocument.IncomingDocumentBuilder();
            builder.id(resultSet.getInt("doc_id"))
                    .name(resultSet.getString("name"))
                    .text(resultSet.getString("text"))
                    .regNumber(resultSet.getString("reg_number"))
                    .regDate(resultSet.getDate("reg_date").toLocalDate());
                    //.author();
            preparedStatement = connection.prepareStatement("SELECT * FROM incoming_document WHERE id = ?");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return builder.outgoingNumber(resultSet.getInt("outgoing_number"))
                    .outgoingRegDate(resultSet.getString("outgoing_reg_date"))
                    //.recipient()
                    //.sender()
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String column, String value) {
    }
    @Override
    public void delete(IncomingDocument incomingDocument) {

    }
}
