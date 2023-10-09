package ru.julia.infogenerators;

import org.springframework.stereotype.Component;
import ru.julia.XMLReader;
import ru.julia.documents.TaskDocument;
import ru.julia.staff.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
/**
 * Класс создает и возвращает объект класса {@link TaskDocument}
 */
@Component
public class TaskDocumentInfoGenerator {
    public String generateIssueDate() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public String generateExecutionTerm() {
        LocalDate localDate = LocalDate.now().plusDays(31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public Person generateResponsibleExecutive() {
            return XMLReader.readPerson();
    }
    public boolean generateControlMark() {
        return new Random().nextBoolean();
    }
    public Person generateController() {
        return XMLReader.readPerson();
    }
}
