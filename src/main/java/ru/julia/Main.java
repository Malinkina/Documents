package ru.julia;

import ru.julia.documents.OutgoingDocument;
import ru.julia.factories.OutgoingDocumentFactory;

public class Main {
    public static void main(String[] args) {
        OutgoingDocument outgoingDocument = new OutgoingDocumentFactory().create();
        System.out.println(outgoingDocument);
    }
}
