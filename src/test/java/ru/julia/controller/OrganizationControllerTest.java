package ru.julia.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.julia.mapper.organization.OrganizationRequestDtoModelMapper;
import ru.julia.servicelayer.service.OrganizationService;

import java.util.UUID;

@WebMvcTest(OrganizationController.class)
class OrganizationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrganizationService service;
    @MockBean
    private OrganizationRequestDtoModelMapper mapper;

    private static final UUID ID = UUID.randomUUID();
    private static final String FULL_NAME = "Organization";
    private static final String SHORT_NAME = "Short name";
    private static final String MANAGER = "Manager";
    private static final String PHONE_NUMBER = "+711111111111";
    private static final String URL = "/organization";
    private static final String URI = URL + "/" + ID;

    @Test
    void create() {
    }

    @Test
    void readAll() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}