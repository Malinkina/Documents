package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DocumentJPA {
    @Id
    private UUID id;
    @Column(name = "document_id")
    private int documentId;
    private String name;
    private String text;
    @Column(name = "reg_number")
    private String regNumber;
    @Column(name = "reg_date")
    private LocalDate regDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private EmployeeJPA author;

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

    public EmployeeJPA getAuthor() {
        return author;
    }

    public void setAuthor(EmployeeJPA author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "DocumentJPA{" +
                "id=" + id +
                ", documentId=" + documentId +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
