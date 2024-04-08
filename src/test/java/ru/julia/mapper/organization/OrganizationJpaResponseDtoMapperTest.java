package ru.julia.mapper.organization;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.response.OrganizationResponseDto;
import ru.julia.orm.jpamodel.OrganizationJpa;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class OrganizationJpaResponseDtoMapperTest {

    private static final OrganizationJpaResponseDtoMapper MAPPER = Mappers.getMapper(OrganizationJpaResponseDtoMapper.class);
    private static final UUID ID = UUID.fromString("7bfdeb4e-d8b4-40c2-b009-e15e5751c6c2");
    private static final String FULL_NAME = "Organization";
    private static final String SHORT_NAME = "Org";
    private static final String MANAGER = "Manager";
    private static final String PHONE_1 = "+71233112";
    private static final String PHONE_2 = "+745125458";
    private static final String DELIMITER = ",";
    private static final String PHONE_NUMBERS = PHONE_1 + DELIMITER + PHONE_2;

    @Test
    void toResponseDto() {
        OrganizationJpa jpa = new OrganizationJpa();
        jpa.setId(ID);
        jpa.setFullName(FULL_NAME);
        jpa.setShortName(SHORT_NAME);
        jpa.setManager(MANAGER);
        jpa.setPhoneNumbers(PHONE_NUMBERS);
        OrganizationResponseDto responseDto = MAPPER.toResponseDto(jpa);
        assertEquals(ID, responseDto.getId());
        assertEquals(FULL_NAME, responseDto.getFullName());
        assertEquals(SHORT_NAME, responseDto.getShortName());
        assertEquals(MANAGER, responseDto.getManager());
        assertEquals(2, responseDto.getPhoneNumbers().size());
    }

    @Test
    void stringPhoneNumbersToList() {
        List<String> phoneNumbersList = MAPPER.stringPhoneNumbersToList(PHONE_NUMBERS);
        assertEquals(phoneNumbersList.get(0), PHONE_1);
        assertEquals(phoneNumbersList.get(1), PHONE_2);
    }

    @Test
    void stringPhoneNumbersToList_whenNull_thenReturnEmptyList() {
        List<String> phoneNumbersList = MAPPER.stringPhoneNumbersToList(null);
        assertEquals(0, phoneNumbersList.size());
    }

    @Test
    void stringPhoneNumbersToList_whenSpaceInNumber_thenTrim() {
        List<String> phoneNumbersList = MAPPER.stringPhoneNumbersToList(PHONE_1 + ", " + PHONE_2);
        assertEquals(phoneNumbersList.get(0), PHONE_1);
        assertEquals(phoneNumbersList.get(1), PHONE_2);
        assertFalse(phoneNumbersList.get(1).contains(" "));
    }
}