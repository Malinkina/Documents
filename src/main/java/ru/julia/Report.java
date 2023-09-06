package ru.julia;

import ru.julia.documents.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

    public void reportGeneratedDocuments(List<Document> documents) {
        Map<String, List<Document>> authorAndDocument = documents.stream()
                .sorted()
                .collect(Collectors.groupingBy(d -> d.getAuthor().toString()));
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
