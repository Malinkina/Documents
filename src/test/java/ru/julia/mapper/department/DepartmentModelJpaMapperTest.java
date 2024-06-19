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
    private static final String PHONE_NUMBERS_JPA = "+71111111,+745612115";

    //todo fields
    @Test
    void toJpa() {
        DepartmentModel model = createDepartmentModel();
        DepartmentJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID, jpa.getId());
        assertEquals(FUlL_NAME_MODEL, jpa.getFullName());
        assertEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertEquals(MANAGER_MODEL, jpa.getManager());
    }

    @Test
    void updateDepartmentJpaFromModel_whenAllFields_thenAllMapped() {
        DepartmentModel model = createDepartmentModel();
        DepartmentJpa jpa = createDepartmentJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(FUlL_NAME_MODEL, jpa.getFullName());
        assertEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertEquals(MANAGER_MODEL, jpa.getManager());
        assertTrue(jpa.getPhoneNumbers().contains(PHONE_1_MODEL));
    }

    @Test
    void updateDepartmentJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        DepartmentModel model = new DepartmentModel();
        model.setId(ID);
        model.setFullName(FUlL_NAME_MODEL);
        DepartmentJpa jpa = createDepartmentJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(FUlL_NAME_MODEL, jpa.getFullName());
        assertNotEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertNotEquals(MANAGER_MODEL, jpa.getManager());
        assertFalse(jpa.getPhoneNumbers().contains(PHONE_1_MODEL));
    }

    @Test
    void updateDepartmentJpaFromModel_whenNull_thenNotMapped() {
        DepartmentModel model = createDepartmentModel();
        model.setFullName(null);
        DepartmentJpa jpa = createDepartmentJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(FULL_NAME_JPA, jpa.getFullName());
        assertEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertEquals(MANAGER_MODEL, jpa.getManager());
        assertTrue(jpa.getPhoneNumbers().contains(PHONE_1_MODEL));
        assertNotNull(jpa.getFullName());
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