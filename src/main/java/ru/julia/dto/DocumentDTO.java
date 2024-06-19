package ru.julia.dto;

import java.time.LocalDate;

public class DocumentDTO {
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private String authorsSurname;
    private String authorsName;
    private String authorsPatronymic;

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

    public String getAuthorsSurname() {
        return authorsSurname;
    }

    public void setAuthorsSurname(String authorsSurname) {
        this.authorsSurname = authorsSurname;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }

    public String getAuthorsPatronymic() {
        return authorsPatronymic;
    }

    public void setAuthorsPatronymic(String authorsPatronymic) {
        this.authorsPatronymic = authorsPatronymic;
    }
}
