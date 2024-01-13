package ru.julia.factory;

import ru.julia.document.Document;

/**
 * Класс определяет поведение классов-фабрик {@link IncomingDocumentFactory}, {@link OutgoingDocumentFactory}, {@link TaskDocumentFactory}
 */
public interface DocumentFactory<T extends Document> {
    T create();
}
