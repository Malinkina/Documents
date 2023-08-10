package ru.julia.infogenerators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
}
