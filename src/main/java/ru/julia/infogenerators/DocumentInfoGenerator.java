package ru.julia.infogenerators;

import org.apache.commons.lang3.RandomStringUtils;
import ru.julia.representatives.InternalRepresentatives;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public static int generateRegNumber() {
        return ((int) (Math.random() * 10));
    }

    public static String generateRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }

    public static String generateAuthor() {
        return InternalRepresentatives.randomRepresentative();
    }
}
