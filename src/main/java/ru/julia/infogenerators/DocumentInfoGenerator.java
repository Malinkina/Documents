package ru.julia.infogenerators;

import org.apache.commons.lang3.RandomStringUtils;
import ru.julia.XMLReader;
import ru.julia.documents.Document;
import ru.julia.staff.Person;

import java.time.LocalDate;

/**
 * Класс генерирует значения для полей класса {@link Document}
 */
public class DocumentInfoGenerator {
    public static int generateId() {
        return ((int) (Math.random() * 100));
    }

    public static String generateName() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String generateText() {
        return RandomStringUtils.randomAlphabetic(20);
    }

    public static String generateRegNumber() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }

    public static LocalDate generateRegDate() {
        return LocalDate.now();
    }

    public static Person generateAuthor() {
        return XMLReader.readPerson();
    }
}
