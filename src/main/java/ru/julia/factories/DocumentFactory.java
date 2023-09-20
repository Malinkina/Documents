package ru.julia.factories;

import ru.julia.documents.Document;

/**
 * Класс определяет поведение классов-фабрик {@link IncomingDocumentFactory}, {@link OutgoingDocumentFactory}, {@link TaskDocumentFactory}
 */
public interface DocumentFactory {
    Document create();
}
