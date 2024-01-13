package ru.julia.domain;

import lombok.Data;

@Data
public class TaskDocument extends Document {
    private String issueDate;
    private String executionTerm;
    private String responsibleExecutiveId;
    private boolean controlMark;
    private String controllerId;
}
