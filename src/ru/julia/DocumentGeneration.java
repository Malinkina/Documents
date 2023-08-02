package ru.julia;

import java.util.*;

public class DocumentGeneration {
    DocumentFactory documentFactory = new DocumentFactory();
    private final List<Document> FACTORY = Arrays.asList(documentFactory.createOutgoingDocument(), documentFactory.createIncomingDocument(), documentFactory.createTaskDocument());
    public List<Document> documents = new ArrayList<>();
    private final List<String> AUTHORS = new ArrayList<>();
    public Map<String, List<Document>> authorAndDocument = new HashMap<>();

    public void generateDocuments() {
        for (int i = 0; i < (int) (Math.random() * 10); i++) {
            documents.add(FACTORY.get((int) (Math.random() * 3)));
        }
    }
    public void convertListToMap(List<Document> documents) {
        for (Document document : documents) {
            if (!AUTHORS.contains(document.author)){
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

