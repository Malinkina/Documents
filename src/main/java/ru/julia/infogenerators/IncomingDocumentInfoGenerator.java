package ru.julia.infogenerators;

import ru.julia.XMLReader;
import ru.julia.documents.IncomingDocument;
import ru.julia.staff.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс генерирует значения для полей класса {@link IncomingDocument}
 */
public class IncomingDocumentInfoGenerator {
    public static Person generateSender() {
        return XMLReader.readPerson();
    }
    public static Person generateRecipient() {
        return XMLReader.readPerson();
    }
    public static int generateOutgoingNumber() {
        return ((int) (Math.random() * 20));
    }
    public static String generateRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
}
