package ru.julia;

import ru.julia.documents.Document;

import java.util.*;
import java.util.stream.Collectors;

public final class Report {
    private static volatile Report instance;

    private Report() {
    }

    public static Report getInstance() {
        if (instance == null) {
            synchronized (Report.class) {
                if (instance == null) {
                    instance = new Report();
                }
            }
        }
        return instance;
    }

    public void reportGeneratedDocs(List<Document> documents) {
        Map<String, List<Document>> authorAndDocument = documents.stream()
                .sorted()
                .collect(Collectors.groupingBy(Document::getAuthor));
        List<String> authors = new ArrayList<>(authorAndDocument.keySet());
        Collections.sort(authors);
        for (String key : authors) {
            System.out.println(key);
            List<Document> docs = authorAndDocument.get(key);
            for (Document doc : docs) {
                System.out.println("\t" + doc.toString());
            }
        }
    }
}
