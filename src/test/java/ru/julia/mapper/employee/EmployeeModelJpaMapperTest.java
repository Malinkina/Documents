package ru.julia.mapper.employee;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.servicelayer.model.EmployeeModel;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeModelJpaMapperTest {
    private static final EmployeeModelJpaMapper MAPPER = Mappers.getMapper(EmployeeModelJpaMapper.class);
    private static final UUID ID = UUID.fromString("4e91e9c6-e8dc-46d9-beed-05b55daf2969");
    private static final String SURNAME_MODEL = "Ivanov";
    private static final String NAME_MODEL = "Ivan";
    private static final String PATRONYMIC_MODEL = "Ivanovich";
    private static final String PHOTO_MODEL = "Photo";
    private static final LocalDate DATE_OF_BIRTH_MODEL = LocalDate.of(1990, 1, 1);
    private static final String PHONE_NUMBER_MODEL = "+799999999";
    private static final String SURNAME_JPA = "Petrov";
    private static final String NAME_JPA = "Petr";
    private static final String PATRONYMIC_JPA = "Petrovich";
    private static final String PHOTO_JPA = "Cool photo";
    private static final LocalDate DATE_OF_BIRTH_JPA = LocalDate.of(1995, 10, 10);
    private static final String PHONE_NUMBER_JPA = "+7111111111";

    @Test
    void toJpa() {
        EmployeeModel model = createEmployeeModel();
        EmployeeJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID, jpa.getId());
        assertEquals(SURNAME_MODEL, jpa.getSurname());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(PATRONYMIC_MODEL, jpa.getPatronymic());
        assertEquals(PHOTO_MODEL, jpa.getPhoto());
        assertEquals(DATE_OF_BIRTH_MODEL, jpa.getDateOfBirth());
        assertEquals(PHONE_NUMBER_MODEL, jpa.getPhoneNumber());
    }

    @Test
    void updateJpaFromModel_whenAllFields_thenAllFieldsMapped() {
        EmployeeJpa jpa = createEmployeeJpa();
        EmployeeModel model = createEmployeeModel();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(SURNAME_MODEL, jpa.getSurname());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(PATRONYMIC_MODEL, jpa.getPatronymic());
        assertEquals(PHOTO_MODEL, jpa.getPhoto());
        assertEquals(DATE_OF_BIRTH_MODEL, jpa.getDateOfBirth());
        assertEquals(PHONE_NUMBER_MODEL, jpa.getPhoneNumber());
    }

    @Test
    void updateJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        EmployeeJpa jpa = createEmployeeJpa();
        EmployeeModel model = new EmployeeModel();
        model.setId(ID);
        model.setPhoneNumber(PHONE_NUMBER_MODEL);
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(SURNAME_JPA, jpa.getSurname());
        assertEquals(NAME_JPA, jpa.getName());
        assertEquals(PATRONYMIC_JPA, jpa.getPatronymic());
        assertEquals(PHOTO_JPA, jpa.getPhoto());
        assertEquals(DATE_OF_BIRTH_JPA, jpa.getDateOfBirth());
        assertEquals(PHONE_NUMBER_MODEL, jpa.getPhoneNumber());
    }

    @Test
    void updateJpaFromModel_whenNull_thenNotMapped() {
        EmployeeModel model = createEmployeeModel();
        model.setPhoto(null);
        EmployeeJpa jpa = createEmployeeJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(SURNAME_MODEL, jpa.getSurname());
        assertEquals(NAME_MODEL, jpa.getName());
        assertEquals(PATRONYMIC_MODEL, jpa.getPatronymic());
        assertEquals(DATE_OF_BIRTH_MODEL, jpa.getDateOfBirth());
        assertEquals(PHONE_NUMBER_MODEL, jpa.getPhoneNumber());
        assertNotNull(jpa.getPhoto());
    }

    private static EmployeeJpa createEmployeeJpa() {
        EmployeeJpa jpa = new EmployeeJpa();
        jpa.setId(ID);
        jpa.setSurname(SURNAME_JPA);
        jpa.setName(NAME_JPA);
        jpa.setPatronymic(PATRONYMIC_JPA);
        jpa.setPhoto(PHOTO_JPA);
        jpa.setDateOfBirth(DATE_OF_BIRTH_JPA);
        jpa.setPhoneNumber(PHONE_NUMBER_JPA);
        return jpa;
    }

    private static EmployeeModel createEmployeeModel() {
        EmployeeModel model = new EmployeeModel();
        model.setId(ID);
        model.setSurname(SURNAME_MODEL);
        model.setName(NAME_MODEL);
        model.setPatronymic(PATRONYMIC_MODEL);
        model.setPhoto(PHOTO_MODEL);
        model.setDateOfBirth(DATE_OF_BIRTH_MODEL);
        model.setPhoneNumber(PHONE_NUMBER_MODEL);
        return model;
    }
}