package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "task_document")
@Data
@NoArgsConstructor
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
}
