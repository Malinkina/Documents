package ru.julia;

import ru.julia.documents.Document;

import java.util.List;

public class GeneratedDocumentCheck {
    public static boolean checkIfDocumentExists(Document document, List<Document> docs) {
        if (docs.size() != 0) {
            for (Document doc : docs) {
                if (document.getRegNumber() == doc.getRegNumber()) {
                    return false;
                }
            }
        }
        return true;
    }
}