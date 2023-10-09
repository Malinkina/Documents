package ru.julia.infogenerators;

import org.springframework.stereotype.Component;
import ru.julia.XMLReader;
import ru.julia.documents.IncomingDocument;
import ru.julia.staff.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс генерирует значения для полей класса {@link IncomingDocument}
 */
@Component
public class IncomingDocumentInfoGenerator {
    public Person generateSender() {
        return XMLReader.readPerson();
    }
    public Person generateRecipient() {
        return XMLReader.readPerson();
    }
    public int generateOutgoingNumber() {
        return ((int) (Math.random() * 20));
    }
    public String generateRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
}
