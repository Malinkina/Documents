package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task_document")
public class TaskDocJpa extends DocumentJpa {
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "execution_term")
    private LocalDate executionTerm;
    @ManyToOne
    @JoinColumn(name = "responsible_executive_id")
    private EmployeeJpa responsibleExecutive;
    @Column(name = "control_mark")
    private Boolean controlMark;
    @ManyToOne
    @JoinColumn(name = "controller_id")
    private EmployeeJpa controller;

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExecutionTerm() {
        return executionTerm;
    }

    public void setExecutionTerm(LocalDate executionTerm) {
        this.executionTerm = executionTerm;
    }

    public EmployeeJpa getResponsibleExecutive() {
        return responsibleExecutive;
    }

    public void setResponsibleExecutive(EmployeeJpa responsibleExecutive) {
        this.responsibleExecutive = responsibleExecutive;
    }

    public Boolean getControlMark() {
        return controlMark;
    }

    public void setControlMark(Boolean controlMark) {
        this.controlMark = controlMark;
    }

    public EmployeeJpa getController() {
        return controller;
    }

    public void setController(EmployeeJpa controller) {
        this.controller = controller;
    }
}
