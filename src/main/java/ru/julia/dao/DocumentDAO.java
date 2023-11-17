package ru.julia.dao;

import org.springframework.stereotype.Component;
import ru.julia.domain.Document;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public abstract class DocumentDAO<T extends Document> {

    public T fill(T t, ResultSet resultSet) {
        try {
            t.setId(resultSet.getString("id"));
            t.setDoc_id(resultSet.getInt("doc_id"));
            t.setName(resultSet.getString("name"));
            t.setText(resultSet.getString("text"));
            t.setRegNumber(resultSet.getString("reg_number"));
            t.setRegDate(resultSet.getDate("reg_date").toLocalDate());
            t.setAuthor_id(resultSet.getString("author_id"));
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
