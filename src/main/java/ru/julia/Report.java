package ru.julia;

import ru.julia.documents.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public final class Report {
    private static Report instance;
    DocumentsGeneration documentGeneration = new DocumentsGeneration();
    private final TreeMap<String, List<Document>> authorAndDocument = new TreeMap<>();
    private final List<String> authors = new ArrayList<>();

    private Report() {
    }

    public static Report getInstance() {
        Report localInstance = instance;
        if (localInstance == null) {
            synchronized (Report.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Report();
                }
            }
        }
        return localInstance;
    }

    public void reportGeneratedDocs() {
        try {
            documentGeneration.generateDocuments();
        } catch (DocumentExistsException e) {
            e.printStackTrace();
        }
        convertListToMap(documentGeneration.documents);
        sortLists();
        print();
    }

    private void convertListToMap(List<Document> documents) {
        for (Document document : documents) {
            if (!authors.contains(document.getAuthor())) {
                authors.add(document.getAuthor());
            }
        }
        for (String author : authors) {
            List<Document> docs = new ArrayList<>();
            for (Document document : documents) {
                if (author.equals(document.getAuthor())) {
                    docs.add(document);
                }
            }
            authorAndDocument.put(author, docs);
        }
    }

    private void print() {
        String author;
        List<Document> docs;
        for (String key : authorAndDocument.keySet()) {
            author = key;
            System.out.println(author);
            docs = authorAndDocument.get(key);
            Document document;
            for (Document doc : docs) {
                document = doc;
                System.out.println("\t" + document.toString());
            }
        }
    }
    private void sortLists() {
        for (List<Document> list : authorAndDocument.values()) {
            Collections.sort(list);
        }
    }
}
