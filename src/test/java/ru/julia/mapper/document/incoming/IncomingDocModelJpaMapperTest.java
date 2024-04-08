package ru.julia.mapper.document.incoming;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.IncomingDocJpa;
import ru.julia.servicelayer.model.IncomingDocModel;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomingDocModelJpaMapperTest {
    private static final IncomingDocModelJpaMapper MAPPER = Mappers.getMapper(IncomingDocModelJpaMapper.class);
    private static final UUID ID = UUID.fromString("1c1b791b-3f64-4977-9794-27fbdec48a23");
    private static final Integer DOC_ID = 1;
    private static final String NAME_MODEL = "Name";
    private static final String TEXT_MODEL = "Text";
    private static final LocalDate REG_DATE_MODEL = LocalDate.now();
    private static final String REG_NUMBER_MODEL = "regNumber";
    private static final Integer OUTGOING_NUMBER_MODEL = 23;
    private static final LocalDate OUTGOING_REG_DATE_MODEL = LocalDate.of(2023, 11, 30);
    private static final String NAME_JPA = "Jpa name";
    private static final String TEXT_JPA = "Jpa text";
    private static final LocalDate REG_DATE_JPA = LocalDate.now();
    private static final String REG_NUMBER_JPA = "jpaRegNumber";
    private static final Integer OUTGOING_NUMBER_JPA = 23;
    private static final LocalDate OUTGOING_REG_DATE_JPA = LocalDate.of(2023, 1, 3);

    @Test
    void toJpa() {
        IncomingDocModel model = createModel();
        IncomingDocJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(OUTGOING_NUMBER_MODEL, jpa.getOutgoingNumber());
        assertEquals(OUTGOING_REG_DATE_MODEL, jpa.getOutgoingRegDate());
    }

    @Test
    void updateJpaFromModel_whenAllFields_thenAllMapped() {
        IncomingDocModel model = createModel();
        IncomingDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(OUTGOING_NUMBER_MODEL, jpa.getOutgoingNumber());
        assertEquals(OUTGOING_REG_DATE_MODEL, jpa.getOutgoingRegDate());
    }

    @Test
    void updateJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        IncomingDocModel model = new IncomingDocModel();
        model.setId(ID);
        model.setText(TEXT_MODEL);
        IncomingDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_JPA, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_JPA, jpa.getRegDate());
        assertEquals(REG_NUMBER_JPA, jpa.getRegNumber());
        assertEquals(OUTGOING_NUMBER_JPA, jpa.getOutgoingNumber());
        assertEquals(OUTGOING_REG_DATE_JPA, jpa.getOutgoingRegDate());
    }

    @Test
    void updateJpaFromModel_whenNull_thenNotMapped() {
        IncomingDocModel model = createModel();
        model.setOutgoingNumber(null);
        IncomingDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(OUTGOING_NUMBER_JPA, jpa.getOutgoingNumber());
        assertEquals(OUTGOING_REG_DATE_MODEL, jpa.getOutgoingRegDate());
    }

    private static IncomingDocModel createModel() {
        IncomingDocModel model = new IncomingDocModel();
        model.setId(ID);
        model.setDocId(DOC_ID);
        model.setName(NAME_MODEL);
        model.setText(TEXT_MODEL);
        model.setRegDate(REG_DATE_MODEL);
        model.setRegNumber(REG_NUMBER_MODEL);
        model.setOutgoingNumber(OUTGOING_NUMBER_MODEL);
        model.setOutgoingRegDate(OUTGOING_REG_DATE_MODEL);
        return model;
    }

    private static IncomingDocJpa createJpa() {
        IncomingDocJpa jpa = new IncomingDocJpa();
        jpa.setId(ID);
        jpa.setDocId(DOC_ID);
        jpa.setName(NAME_JPA);
        jpa.setText(TEXT_JPA);
        jpa.setRegDate(REG_DATE_JPA);
        jpa.setRegNumber(REG_NUMBER_JPA);
        jpa.setOutgoingNumber(OUTGOING_NUMBER_JPA);
        jpa.setOutgoingRegDate(OUTGOING_REG_DATE_JPA);
        return jpa;
    }
}