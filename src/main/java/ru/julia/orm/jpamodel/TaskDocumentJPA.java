package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

@Entity
@Table(name = "task_document")
public class TaskDocumentJPA extends DocumentJPA {
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "execution_term")
    private String executionTerm;
    @ManyToOne
    @JoinColumn(name = "responsible_executive_id")
    private EmployeeJPA responsibleExecutive;
    @Column(name = "control_mark")
    private boolean controlMark;
    @ManyToOne
    @JoinColumn(name = "controller_id")
    private EmployeeJPA controller;

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

    public EmployeeJPA getResponsibleExecutive() {
        return responsibleExecutive;
    }

    public void setResponsibleExecutive(EmployeeJPA responsibleExecutive) {
        this.responsibleExecutive = responsibleExecutive;
    }

    public boolean isControlMark() {
        return controlMark;
    }

    public void setControlMark(boolean controlMark) {
        this.controlMark = controlMark;
    }

    public EmployeeJPA getController() {
        return controller;
    }

    public void setController(EmployeeJPA controller) {
        this.controller = controller;
    }
}