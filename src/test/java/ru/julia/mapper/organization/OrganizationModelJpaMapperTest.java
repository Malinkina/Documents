package ru.julia.mapper.organization;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.servicelayer.model.OrganizationModel;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationModelJpaMapperTest {

    private static final OrganizationModelJpaMapper MAPPER = Mappers.getMapper(OrganizationModelJpaMapper.class);
    private static final UUID ID = UUID.fromString("17fb02bb-e0c8-4c56-99e4-c2deb93eb56e");
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

    @Test
    void toJpa() {
        OrganizationModel model = createOrganizationModel();
        OrganizationJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID, jpa.getId());
        assertEquals(FUlL_NAME_MODEL, jpa.getFullName());
        assertEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertEquals(MANAGER_MODEL, jpa.getManager());
        assertTrue(jpa.getPhoneNumbers().contains(PHONE_1_MODEL));
    }

    @Test
    void updateJpaFromModel_whenAllFields_thenAllMapped() {
        OrganizationModel model = createOrganizationModel();
        OrganizationJpa jpa = createOrganizationJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(FUlL_NAME_MODEL, jpa.getFullName());
        assertEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertEquals(MANAGER_MODEL, jpa.getManager());
        assertTrue(jpa.getPhoneNumbers().contains(PHONE_1_MODEL));
    }

    @Test
    void updateJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        OrganizationModel model = new OrganizationModel();
        model.setId(ID);
        model.setFullName(FUlL_NAME_MODEL);
        OrganizationJpa jpa = createOrganizationJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(FUlL_NAME_MODEL, jpa.getFullName());
        assertEquals(SHORT_NAME_JPA, jpa.getShortName());
        assertEquals(MANAGER_JPA, jpa.getManager());
        assertTrue(jpa.getPhoneNumbers().contains(PHONE_NUMBERS_JPA));
    }

    @Test
    void updateJpaFromModel_whenNull_thenNotMapped() {
        OrganizationModel model = createOrganizationModel();
        model.setFullName(null);
        OrganizationJpa jpa = createOrganizationJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID, jpa.getId());
        assertEquals(SHORT_NAME_MODEL, jpa.getShortName());
        assertEquals(MANAGER_MODEL, jpa.getManager());
        assertTrue(jpa.getPhoneNumbers().contains(PHONE_1_MODEL));
        assertNotNull(jpa.getPhoneNumbers());
    }

    @Test
    void listPhoneNumbersToString() {
        String phoneNumbersAsString = MAPPER.listPhoneNumbersToString(PHONE_NUMBERS_MODEL);
        assertTrue(phoneNumbersAsString.contains(PHONE_1_MODEL) && phoneNumbersAsString.contains(PHONE_2_MODEL));
        assertFalse(phoneNumbersAsString.contains(" "));
    }

    private static OrganizationModel createOrganizationModel() {
        OrganizationModel model = new OrganizationModel();
        model.setId(ID);
        model.setFullName(FUlL_NAME_MODEL);
        model.setShortName(SHORT_NAME_MODEL);
        model.setManager(MANAGER_MODEL);
        model.setPhoneNumbers(PHONE_NUMBERS_MODEL);
        return model;
    }

    private static OrganizationJpa createOrganizationJpa() {
        OrganizationJpa jpa = new OrganizationJpa();
        jpa.setId(ID);
        jpa.setFullName(FULL_NAME_JPA);
        jpa.setShortName(SHORT_NAME_JPA);
        jpa.setManager(MANAGER_JPA);
        jpa.setPhoneNumbers(PHONE_NUMBERS_JPA);
        return jpa;
    }
}