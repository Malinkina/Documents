package ru.julia.infogenerators;

import ru.julia.representatives.ExternalRepresentatives;
import ru.julia.representatives.InternalRepresentatives;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TaskDocumentInfoGenerator {
    public static String generateIssueDate() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public static String generateExecutionTerm() {
        LocalDate localDate = LocalDate.now().plusDays(31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public static String generateResponsibleExecutive() {
            return ExternalRepresentatives.representatives.get((int) (Math.random() * 3));
    }
    public static boolean generateControlMark() {
        return new Random().nextBoolean();
    }
    public static String generateController() {
        return InternalRepresentatives.representatives.get((int) (Math.random() * 4));
    }
}
