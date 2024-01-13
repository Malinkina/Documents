package ru.julia;

import org.springframework.stereotype.Component;
import ru.julia.document.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Показывает отчет по сгенерируемым документам
 */
@Component
public final class Report {
    public Map<String, List<Document>> reportGeneratedDocuments(List<Document> documents) {
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
        return authorAndDocument;
    }
}
