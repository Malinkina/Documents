package ru.julia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import ru.julia.controller.dto.request.EmployeeRequestDto;
import ru.julia.controller.dto.response.EmployeeResponseDto;
import ru.julia.controller.dto.response.ErrorDto;
import ru.julia.mapper.employee.EmployeeRequestDtoModelMapper;
import ru.julia.servicelayer.model.EmployeeModel;
import ru.julia.servicelayer.service.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRequestDtoModelMapper mapper;
    public static final String SURNAME = "Ivanov";

    public static final String NAME = "Ivan";
    public static final String PATRONYMIC = "Ivanovich";
    public static final String PHOTO = "Photo";
    public static final LocalDate DATE_OF_BIRTH = LocalDate.of(90, 2, 23);
    public static final String PHONE_NUMBER = "+7988244454";
    private static final UUID ID = UUID.randomUUID();
    private static final String URL = "/employees";
    private static final String URI = URL + "/" + ID;

    @Nested
    class CreateEmployee {
        @Test
        void createValidEmployee() throws Exception {
            EmployeeRequestDto employeeRequestDto = getEmployeeRequestDto();
            EmployeeModel employeeModel = getEmployeeModel();
            when(mapper.toModel(employeeRequestDto)).thenReturn(employeeModel);
            String inputJson = mapToJson(employeeRequestDto);
            mockMvc.perform(post(URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(inputJson))
                    .andExpect(status().isOk());
            verify(mapper, times(1)).toModel(employeeRequestDto);
            verify(service, times(1)).create(employeeModel);
        }

        @ParameterizedTest
        @MethodSource("provideEmployeeWithNullField")
        void createInvalidEmployee(EmployeeRequestDto employee, ErrorDto errorDto) throws Exception {
            String inputJson = mapToJson(employee);
            String errorJson = mapToJson(errorDto);
            mockMvc.perform(post(URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(inputJson))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(errorJson));
        }

        private static Stream<Arguments> provideEmployeeWithNullField() {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrors(new ArrayList<>());
            errorDto.getErrors().add("surname must not be null");
            errorDto.getErrors().add("name must not be null");
            errorDto.getErrors().add("patronymic must not be null");
            errorDto.getErrors().add("dateOfBirth must not be null");
            errorDto.getErrors().add("phoneNumber must not be null");
            errorDto.getErrors().add("departmentId must not be null");
            errorDto.getErrors().add("organizationId must not be null");
            errorDto.getErrors().add("positionId must not be null");
            return Stream.of(
                    Arguments.of(new EmployeeRequestDto(), errorDto)
            );
        }
    }

    @Test
    void readAll() throws Exception {
        List<EmployeeResponseDto> employees = List.of();
        when(service.readAll()).thenReturn(employees);
        mockMvc.perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(service, times(1)).readAll();
    }

    @Test
    void read() throws Exception {
        when(service.read(ID)).thenReturn(new EmployeeResponseDto());
        mockMvc.perform(get(URI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        verify(service, times(1)).read(ID);
    }

    @Test
    void update() throws Exception {
        EmployeeModel employeeModel = getEmployeeModel();
        EmployeeRequestDto employeeRequestDto = getEmployeeRequestDto();
        when(mapper.toModel(employeeRequestDto)).thenReturn(employeeModel);
        String inputJson = mapToJson(employeeRequestDto);
        mockMvc.perform(put(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk());
        verify(service, times(1)).update(ID, employeeModel);
        verify(mapper, times(1)).toModel(employeeRequestDto);
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(URI))
                .andExpect(status().isOk());
        verify(service, times(1)).delete(ID);
    }

    private static EmployeeRequestDto getEmployeeRequestDto() {
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
        employeeRequestDto.setSurname(SURNAME);
        employeeRequestDto.setName(NAME);
        employeeRequestDto.setPatronymic(PATRONYMIC);
        employeeRequestDto.setPhoto(PHOTO);
        employeeRequestDto.setDateOfBirth(DATE_OF_BIRTH);
        employeeRequestDto.setPhoneNumber(PHONE_NUMBER);
        employeeRequestDto.setDepartmentId(ID);
        employeeRequestDto.setOrganizationId(ID);
        employeeRequestDto.setPositionId(ID);
        return employeeRequestDto;
    }

    private static EmployeeModel getEmployeeModel() {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(ID);
        employeeModel.setSurname("Ivanova");
        employeeModel.setName("Ivana");
        employeeModel.setPatronymic("Ivanovna");
        employeeModel.setPhoto("PhotoM");
        employeeModel.setDateOfBirth(LocalDate.of(94, 4, 23));
        employeeModel.setPhoneNumber("+711111111");
        employeeModel.setDepartmentId(ID);
        employeeModel.setOrganizationId(ID);
        employeeModel.setPositionId(ID);
        return employeeModel;
    }

    private String mapToJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(o);
    }
}
