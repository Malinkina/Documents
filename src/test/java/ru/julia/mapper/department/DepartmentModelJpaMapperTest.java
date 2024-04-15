package ru.julia.mapper.department;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.DepartmentJpa;
import ru.julia.servicelayer.model.DepartmentModel;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentModelJpaMapperTest {
    private static final DepartmentModelJpaMapper MAPPER = Mappers.getMapper(DepartmentModelJpaMapper.class);
    private static final UUID ID = UUID.fromString("7bfdeb4e-d8b4-40c2-b009-e15e5751c6c2");
    private static final String FUlL_NAME_MODEL = "Organization";
    private static final String FULL_NAME_JPA = "OrganizationFromDb";
    private static final String SHORT_NAME_MODEL = "Org";
    private static final String SHORT_NAME_JPA = "Orgnztn";
    private static final String MANAGER_MODEL = "Manager";
    private static final String MANAGER_JPA = "Ivanov";
    private static final String PHONE_1_MODEL = "+71233112";
    private static final String PHONE_2_MODEL = "+745125458";
    private static final List<String> PHONE_NUMBERS_MODEL = Arrays.asList(PHONE_1_MODEL, PHONE_2_MODEL);
    private static final String PHONE_NUMBERS_JPA = "+71233112,+745125458";

    @Test
    void toJpa() {
        DepartmentModel model = createDepartmentModel();
        DepartmentJpa actual = MAPPER.toJpa(model);
        DepartmentJpa expected = new DepartmentJpa(
                ID, FUlL_NAME_MODEL, SHORT_NAME_MODEL, MANAGER_MODEL, PHONE_NUMBERS_JPA, null
        );
        assertEquals(expected, actual);
    }

    @Test
    void updateDepartmentJpaFromModel_whenAllFields_thenAllMapped() {
        DepartmentModel model = createDepartmentModel();
        DepartmentJpa actual = createDepartmentJpa();
        MAPPER.updateJpaFromModel(model, actual);
        DepartmentJpa expected = new DepartmentJpa(
                ID, FUlL_NAME_MODEL, SHORT_NAME_MODEL, MANAGER_MODEL, PHONE_NUMBERS_JPA, null
        );
        assertEquals(expected, actual);
    }

    @Test
    void updateDepartmentJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        DepartmentModel model = new DepartmentModel();
        model.setFullName(FUlL_NAME_MODEL);
        DepartmentJpa actual = createDepartmentJpa();
        MAPPER.updateJpaFromModel(model, actual);
        DepartmentJpa expected = new DepartmentJpa(
                ID, FUlL_NAME_MODEL, SHORT_NAME_JPA, MANAGER_JPA, PHONE_NUMBERS_JPA, null
        );
        assertEquals(expected, actual);
    }

    @Test
    void updateDepartmentJpaFromModel_whenNull_thenNotMapped() {
        DepartmentModel model = createDepartmentModel();
        model.setFullName(null);
        DepartmentJpa actual = createDepartmentJpa();
        MAPPER.updateJpaFromModel(model, actual);
        DepartmentJpa expected = new DepartmentJpa(
                ID, FULL_NAME_JPA, SHORT_NAME_MODEL, MANAGER_MODEL, PHONE_NUMBERS_JPA, null
        );
        assertEquals(expected, actual);
    }

    @Test
    void listPhoneNumbersToString() {
        String phoneNumbersAsString = MAPPER.listPhoneNumbersToString(PHONE_NUMBERS_MODEL);
        assertTrue(phoneNumbersAsString.contains(PHONE_1_MODEL) && phoneNumbersAsString.contains(PHONE_2_MODEL));
        assertFalse(phoneNumbersAsString.contains(" "));
    }

    private static DepartmentModel createDepartmentModel() {
        DepartmentModel model = new DepartmentModel();
        model.setId(ID);
        model.setFullName(FUlL_NAME_MODEL);
        model.setShortName(SHORT_NAME_MODEL);
        model.setManager(MANAGER_MODEL);
        model.setPhoneNumbers(PHONE_NUMBERS_MODEL);
        return model;
    }

    private static DepartmentJpa createDepartmentJpa() {
        DepartmentJpa jpa = new DepartmentJpa();
        jpa.setId(ID);
        jpa.setFullName(FULL_NAME_JPA);
        jpa.setShortName(SHORT_NAME_JPA);
        jpa.setManager(MANAGER_JPA);
        jpa.setPhoneNumbers(PHONE_NUMBERS_JPA);
        return jpa;
    }
}