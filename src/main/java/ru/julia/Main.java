package ru.julia;

import ru.julia.documents.TaskDocument;
import ru.julia.factories.TaskDocumentFactory;

public class Main {
    public static void main(String[] args) {
        TaskDocument taskDocument = new TaskDocumentFactory().create();
        System.out.println(taskDocument);
    }
}
