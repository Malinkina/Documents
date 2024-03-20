package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DocumentJpa {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "document_id")
    private Integer docId;
    private String name;
    private String text;
    @Column(name = "reg_number")
    private String regNumber;
    @Column(name = "reg_date")
    private LocalDate regDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private EmployeeJpa author;

    @PrePersist
    private void setPk(){
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
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

    public EmployeeJpa getAuthor() {
        return author;
    }

    public void setAuthor(EmployeeJpa author) {
        this.author = author;
    }
}
