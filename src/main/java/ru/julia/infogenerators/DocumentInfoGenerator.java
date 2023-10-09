package ru.julia.infogenerators;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import ru.julia.XMLReader;
import ru.julia.documents.Document;
import ru.julia.staff.Person;

import java.time.LocalDate;

/**
 * Класс генерирует значения для полей класса {@link Document}
 */
@Component
public class DocumentInfoGenerator {
    public int generateId() {
        return ((int) (Math.random() * 100));
    }

    public String generateName() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String generateText() {
        return RandomStringUtils.randomAlphabetic(20);
    }

    public String generateRegNumber() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }

    public LocalDate generateRegDate() {
        return LocalDate.now();
    }

    public Person generateAuthor() {
        return XMLReader.readPerson();
    }
}
