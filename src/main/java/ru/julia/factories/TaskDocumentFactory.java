package ru.julia.factories;

import ru.julia.builders.TaskDocumentBuilder;
import ru.julia.documents.TaskDocument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskDocumentFactory extends DocumentFactory {
    TaskDocumentBuilder builder = new TaskDocumentBuilder();
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
    @Override
    public TaskDocument create() {
        TaskDocument taskDocument = new TaskDocument();
        builder.build(taskDocument);
        return taskDocument;
    }
}
