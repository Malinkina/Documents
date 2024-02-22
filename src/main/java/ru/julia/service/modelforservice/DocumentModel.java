package ru.julia.service.modelforservice;

import ru.julia.xml.xmlmodel.EmployeeXML;

import java.time.LocalDate;
import java.util.UUID;

public class DocumentModel {
    private UUID id;
    private int documentId;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private EmployeeXML author;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public EmployeeXML getAuthor() {
        return author;
    }

    public void setAuthor(EmployeeXML author) {
        this.author = author;
    }
}
