package ru.julia.mapper.document.task;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.TaskDocJpa;
import ru.julia.servicelayer.model.TaskDocModel;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskDocModelJpaMapperTest {
    private static final TaskDocModelJpaMapper MAPPER = Mappers.getMapper(TaskDocModelJpaMapper.class);
    private static final UUID ID = UUID.fromString("1c1b791b-3f64-4977-9794-27fbdec48a23");
    private static final Integer DOC_ID = 1;
    private static final String NAME_MODEL = "Name";
    private static final String TEXT_MODEL = "Text";
    private static final String REG_NUMBER_MODEL = "regNumber";
    private static final LocalDate REG_DATE_MODEL = LocalDate.now();
    private static final UUID AUTHOR_ID_MODEL = UUID.fromString("22b1ecea-fe99-4f34-a5ea-c992f538abe7");
    private static final LocalDate ISSUE_DATE_MODEL = LocalDate.now();
    private static final LocalDate EXECUTION_TERM_MODEL = LocalDate.of(2024, 3, 31);
    private static final UUID RESPONSIBLE_EXECUTIVE_ID_MODEL = UUID.fromString("3285aa2d-7218-41a9-acaa-280105303d8f");
    public static final Boolean CONTROL_MARK_MODEL = true;
    public static final UUID CONTROLLER_ID_MODEL = UUID.fromString("e6bbd867-b4c7-42d1-b63e-28a0b687286a");
    private static final String NAME_JPA = "NameJpa";
    private static final String TEXT_JPA = "TextJpa";
    private static final String REG_NUMBER_JPA = "regNumberJpa";
    private static final LocalDate REG_DATE_JPA = LocalDate.now();
    private static final LocalDate ISSUE_DATE_JPA = LocalDate.now();
    private static final LocalDate EXECUTION_TERM_JPA = LocalDate.of(2024, 1, 1);
    public static final Boolean CONTROL_MARK_JPA = false;

    @Test
    void toJpa() {
        TaskDocModel model = createModel();
        TaskDocJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(EXECUTION_TERM_MODEL, jpa.getExecutionTerm());
        assertEquals(ISSUE_DATE_MODEL, jpa.getIssueDate());
        assertEquals(CONTROL_MARK_MODEL, jpa.getControlMark());
    }

    @Test
    void updateJpaFromModel_whenAllFields_thenAllMapped() {
        TaskDocModel model = createModel();
        TaskDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(EXECUTION_TERM_MODEL, jpa.getExecutionTerm());
        assertEquals(ISSUE_DATE_MODEL, jpa.getIssueDate());
        assertEquals(CONTROL_MARK_MODEL, jpa.getControlMark());
    }

    @Test
    void updateJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        TaskDocModel model = new TaskDocModel();
        model.setId(ID);
        model.setText(TEXT_MODEL);
        TaskDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_JPA, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_JPA, jpa.getRegDate());
        assertEquals(REG_NUMBER_JPA, jpa.getRegNumber());
        assertEquals(EXECUTION_TERM_JPA, jpa.getExecutionTerm());
        assertEquals(ISSUE_DATE_JPA, jpa.getIssueDate());
        assertEquals(CONTROL_MARK_JPA, jpa.getControlMark());
    }

    @Test
    void updateJpaFromModel_whenNull_thenNotMapped() {
        TaskDocModel model = createModel();
        model.setExecutionTerm(null);
        TaskDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(EXECUTION_TERM_JPA, jpa.getExecutionTerm());
        assertEquals(ISSUE_DATE_MODEL, jpa.getIssueDate());
        assertEquals(CONTROL_MARK_MODEL, jpa.getControlMark());
    }

    private static TaskDocJpa createJpa() {
        TaskDocJpa jpa = new TaskDocJpa();
        jpa.setId(ID);
        jpa.setDocId(DOC_ID);
        jpa.setName(NAME_JPA);
        jpa.setText(TEXT_JPA);
        jpa.setRegNumber(REG_NUMBER_JPA);
        jpa.setRegDate(REG_DATE_JPA);
        jpa.setIssueDate(ISSUE_DATE_JPA);
        jpa.setExecutionTerm(EXECUTION_TERM_JPA);
        jpa.setControlMark(CONTROL_MARK_JPA);
        return jpa;
    }

    private static TaskDocModel createModel() {
        TaskDocModel model = new TaskDocModel();
        model.setId(ID);
        model.setDocId(DOC_ID);
        model.setName(NAME_MODEL);
        model.setText(TEXT_MODEL);
        model.setRegNumber(REG_NUMBER_MODEL);
        model.setRegDate(REG_DATE_MODEL);
        model.setAuthorId(AUTHOR_ID_MODEL);
        model.setIssueDate(ISSUE_DATE_MODEL);
        model.setExecutionTerm(EXECUTION_TERM_MODEL);
        model.setResponsibleExecutiveId(RESPONSIBLE_EXECUTIVE_ID_MODEL);
        model.setControlMark(CONTROL_MARK_MODEL);
        model.setControllerId(CONTROLLER_ID_MODEL);
        return model;
    }
}