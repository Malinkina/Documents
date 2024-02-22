package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "task_document")
public class JPATaskDocument {
    @Id
    private UUID id;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "execution_term")
    private String executionTerm;
    @ManyToOne
    @JoinColumn(name = "responsible_executive_id")
    private JPAEmployee responsibleExecutive;
    @Column(name = "control_mark")
    private boolean controlMark;
    @ManyToOne
    @JoinColumn(name = "controller_id")
    private JPAEmployee controller;
    @OneToOne
    @JoinColumn(name = "document_id")
    private JPADocument jpaDocument;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExecutionTerm() {
        return executionTerm;
    }

    public void setExecutionTerm(String executionTerm) {
        this.executionTerm = executionTerm;
    }

    public JPAEmployee getResponsibleExecutive() {
        return responsibleExecutive;
    }

    public void setResponsibleExecutive(JPAEmployee responsibleExecutive) {
        this.responsibleExecutive = responsibleExecutive;
    }

    public boolean isControlMark() {
        return controlMark;
    }

    public void setControlMark(boolean controlMark) {
        this.controlMark = controlMark;
    }

    public JPAEmployee getController() {
        return controller;
    }

    public void setController(JPAEmployee controller) {
        this.controller = controller;
    }
}
