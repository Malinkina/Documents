package ru.julia.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.julia.domain.Document;
import ru.julia.dto.DocumentDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DocumentDAO {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public void create(Document document) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO document VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setInt(2, document.getDocId());
            preparedStatement.setString(3, document.getName());
            preparedStatement.setString(4, document.getText());
            preparedStatement.setString(5, document.getRegNumber());
            preparedStatement.setDate(6, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(7, document.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DocumentDTO read(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM document JOIN employee e ON document.author_id = e.id WHERE document.id = ?"
            );
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            DocumentDTO documentDTO = new DocumentDTO();
            resultSet.next();
            documentDTO.setName(resultSet.getString("name"));
            documentDTO.setText(resultSet.getString("text"));
            documentDTO.setRegNumber(resultSet.getString("reg_number"));
            documentDTO.setRegDate(resultSet.getDate("reg_date").toLocalDate());
            documentDTO.setAuthorsSurname(resultSet.getString("surname"));
            documentDTO.setAuthorsName(resultSet.getString(10));
            documentDTO.setAuthorsPatronymic(resultSet.getString("patronymic"));
            return documentDTO;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DocumentDTO> readAll() {
        List<DocumentDTO> documentDTOList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM document JOIN employee e on document.author_id = e.id"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.isLast()) {
                resultSet.next();
                DocumentDTO documentDTO = new DocumentDTO();
                documentDTO.setName(resultSet.getString("name"));
                documentDTO.setText(resultSet.getString("text"));
                documentDTO.setRegNumber(resultSet.getString("reg_number"));
                documentDTO.setRegDate(resultSet.getDate("reg_date").toLocalDate());
                documentDTO.setAuthorsSurname(resultSet.getString("surname"));
                documentDTO.setAuthorsName(resultSet.getString(10));
                documentDTO.setAuthorsPatronymic(resultSet.getString("patronymic"));
                documentDTOList.add(documentDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return documentDTOList;
    }

    public void update(String id, Document document) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE document SET name = ?, text = ? WHERE id = ?"
            );
            if (document.getText() != null && document.getName() != null) {
                preparedStatement.setString(1, document.getName());
                preparedStatement.setString(2, document.getText());
                preparedStatement.setString(3, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
