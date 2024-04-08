package ru.julia.mapper.document.outgoing;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.OutgoingDocJpa;
import ru.julia.servicelayer.model.OutgoingDocModel;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutgoingDocModelJpaMapperTest {
    private static final OutgoingDocModelJpaMapper MAPPER = Mappers.getMapper(OutgoingDocModelJpaMapper.class);
    private static final UUID ID = UUID.fromString("1c1b791b-3f64-4977-9794-27fbdec48a23");
    private static final Integer DOC_ID = 1;
    private static final String NAME_MODEL = "Name";
    private static final String TEXT_MODEL = "Text";
    private static final String REG_NUMBER_MODEL = "regNumber";
    private static final LocalDate REG_DATE_MODEL = LocalDate.now();
    private static final String DELIVERY_TYPE_MODEL = "deliveryType";
    private static final String NAME_JPA = "Jpa name";
    private static final String TEXT_JPA = "Jpa text";
    private static final String REG_NUMBER_JPA = "jpaRegNumber";
    private static final LocalDate REG_DATE_JPA = LocalDate.now();
    private static final String DELIVERY_TYPE_JPA = "deliveryTypeJpa";

    @Test
    void toJpa() {
        OutgoingDocModel model = createModel();
        OutgoingDocJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(DELIVERY_TYPE_MODEL, jpa.getDeliveryType());
    }

    @Test
    void updateJpaFromModel_whenAllFields_thenAllMapped() {
        OutgoingDocModel model = createModel();
        OutgoingDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(DELIVERY_TYPE_MODEL, jpa.getDeliveryType());
    }

    @Test
    void updateJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        OutgoingDocModel model = new OutgoingDocModel();
        model.setDeliveryType(DELIVERY_TYPE_MODEL);
        OutgoingDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_JPA, jpa.getName());
        assertEquals(TEXT_JPA, jpa.getText());
        assertEquals(REG_NUMBER_JPA, jpa.getRegNumber());
        assertEquals(REG_DATE_JPA, jpa.getRegDate());
        assertEquals(DELIVERY_TYPE_MODEL, jpa.getDeliveryType());
    }

    @Test
    void updateJpaFromModel_whenNull_thenNotMapped() {
        OutgoingDocModel model = createModel();
        model.setDeliveryType(null);
        OutgoingDocJpa jpa = createJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(DOC_ID, jpa.getDocId());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(TEXT_MODEL, jpa.getText());
        assertEquals(REG_NUMBER_MODEL, jpa.getRegNumber());
        assertEquals(REG_DATE_MODEL, jpa.getRegDate());
        assertEquals(DELIVERY_TYPE_JPA, jpa.getDeliveryType());
    }

    private static OutgoingDocModel createModel() {
        OutgoingDocModel model = new OutgoingDocModel();
        model.setId(ID);
        model.setDocId(DOC_ID);
        model.setName(NAME_MODEL);
        model.setText(TEXT_MODEL);
        model.setRegNumber(REG_NUMBER_MODEL);
        model.setRegDate(REG_DATE_MODEL);
        model.setDeliveryType(DELIVERY_TYPE_MODEL);
        return model;
    }

    private static OutgoingDocJpa createJpa() {
        OutgoingDocJpa jpa = new OutgoingDocJpa();
        jpa.setId(ID);
        jpa.setDocId(DOC_ID);
        jpa.setName(NAME_JPA);
        jpa.setText(TEXT_JPA);
        jpa.setRegNumber(REG_NUMBER_JPA);
        jpa.setRegDate(REG_DATE_JPA);
        jpa.setDeliveryType(DELIVERY_TYPE_JPA);
        return jpa;
    }
}