package ru.julia;

import ru.julia.documents.Document;

import java.util.*;

public class DocumentGeneration {

    public List<Document> documents = new ArrayList<>();
    private final List<String> AUTHORS = new ArrayList<>();
    public Map<String, List<Document>> authorAndDocument = new HashMap<>();

    public void generateDocuments() {

    }

    public void convertListToMap(List<Document> documents) {
        for (Document document : documents) {
            if (!AUTHORS.contains(document.author)) {
                AUTHORS.add(document.author);
            }
        }
        for (String author : AUTHORS) {
            List<Document> docs = new ArrayList<>();
            for (Document document : documents) {
                if (author.equals(document.author)) {
                    docs.add(document);
                }
            }
            authorAndDocument.put(author, docs);
        }
    }
}

