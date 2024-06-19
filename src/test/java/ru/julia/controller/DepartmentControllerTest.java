package ru.julia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.julia.controller.dto.request.DepartmentRequestDto;
import ru.julia.controller.dto.response.DepartmentResponseDto;
import ru.julia.controller.dto.response.ErrorDto;
import ru.julia.mapper.department.DepartmentRequestDtoModelMapper;
import ru.julia.servicelayer.model.DepartmentModel;
import ru.julia.servicelayer.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService service;
    @MockBean
    private DepartmentRequestDtoModelMapper mapper;

    private static final UUID ID = UUID.randomUUID();
    private static final String FULL_NAME = "Department";
    private static final String SHORT_NAME = "Short name";
    private static final String MANAGER = "Manager";
    private static final String PHONE_NUMBER = "+711111111111";
    private static final String ORG_ID = "c342a577-f8ce-4970-83e7-e7bbccf23ef7";
    private static final String URL = "/departments";
    private static final String URI = URL + "/" + ID;

    @Nested
    class CreateDepartment {
        @Test
        void createValidDepartment() throws Exception {
            DepartmentRequestDto departmentRequestDto = getDepartmentRequestDto();
            DepartmentModel departmentModel = getDepartmentModel();
            when(mapper.toModel(departmentRequestDto)).thenReturn(departmentModel);
            String inputJson = mapToJson(departmentRequestDto);
            mockMvc.perform(post(URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(inputJson))
                    .andExpect(status().isOk());
            verify(mapper, times(1)).toModel(departmentRequestDto);
            verify(service, times(1)).create(departmentModel);
        }

        @ParameterizedTest
        @MethodSource("provideDepartmentWithNullField")
        void createInvalidDepartment(DepartmentRequestDto department, ErrorDto errorDto) throws Exception {
            String inputJson = mapToJson(department);
            String errorJson = mapToJson(errorDto);
            mockMvc.perform(post(URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(inputJson))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(errorJson));
        }

        private static Stream<Arguments> provideDepartmentWithNullField() {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrors(new ArrayList<>());
            errorDto.getErrors().add("fullName must not be null");
            errorDto.getErrors().add("shortName must not be null");
            errorDto.getErrors().add("manager must not be null");
            errorDto.getErrors().add("phoneNumbers must not be null");
            errorDto.getErrors().add("organizationId must not be null");
            return Stream.of(
                    Arguments.of(new DepartmentRequestDto(), errorDto)
            );
        }
    }

    @Test
    void readAll() throws Exception {
        List<DepartmentResponseDto> departments = List.of();
        when(service.readAll()).thenReturn(departments);
        mockMvc.perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(service, times(1)).readAll();
    }

    @Test
    void read() throws Exception {
        when(service.read(ID)).thenReturn(new DepartmentResponseDto());
        mockMvc.perform(get(URI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        verify(service, times(1)).read(ID);
    }

    @Test
    void update() throws Exception {
        DepartmentModel departmentModel = getDepartmentModel();
        DepartmentRequestDto departmentRequestDto = getDepartmentRequestDto();
        when(mapper.toModel(departmentRequestDto)).thenReturn(departmentModel);
        String inputJson = mapToJson(departmentRequestDto);
        mockMvc.perform(put(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk());
        verify(service, times(1)).update(ID, departmentModel);
        verify(mapper, times(1)).toModel(departmentRequestDto);
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(URI))
                .andExpect(status().isOk());
        verify(service, times(1)).delete(ID);

    }

    private static DepartmentRequestDto getDepartmentRequestDto() {
        DepartmentRequestDto department = new DepartmentRequestDto();
        department.setFullName(FULL_NAME);
        department.setShortName(SHORT_NAME);
        department.setPhoneNumbers(List.of(PHONE_NUMBER));
        department.setManager(MANAGER);
        department.setOrganizationId(UUID.fromString(ORG_ID));
        return department;
    }

    private static DepartmentModel getDepartmentModel() {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setId(ID);
        departmentModel.setFullName("Org");
        departmentModel.setShortName("ShNm");
        departmentModel.setPhoneNumbers(List.of("+72222"));
        departmentModel.setManager("Mngr");
        departmentModel.setOrganizationId(UUID.fromString(ORG_ID));
        return departmentModel;
    }


    private String mapToJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }
}