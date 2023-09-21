package ru.julia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.julia.documents.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Сериализирует сгенерированные документы
 */
public class Serialization {
    public void serialize(Map<String, List<Document>> docs) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        for (String author : docs.keySet()) {
            File file = new File(author);
            try {
                mapper.writeValue(file, docs.get(author));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
