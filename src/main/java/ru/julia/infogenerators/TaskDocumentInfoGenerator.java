package ru.julia.infogenerators;

import ru.julia.XMLReader;
import ru.julia.documents.TaskDocument;
import ru.julia.staff.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
/**
 * Класс создает и возвращает объект класса {@link TaskDocument}
 */
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
    public static Person generateResponsibleExecutive() {
            return XMLReader.readPerson();
    }
    public static boolean generateControlMark() {
        return new Random().nextBoolean();
    }
    public static Person generateController() {
        return XMLReader.readPerson();
    }
}
