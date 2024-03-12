package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.dto.request.EmployeeRequestDTO;
import ru.julia.dto.response.EmployeeResponseDTO;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.servicelayer.model.EmployeeModel;
import ru.julia.xml.xmlmodel.EmployeeXML;

import java.util.UUID;

@Component
public class EmployeeMapper {
    public EmployeeModel xmlToModel(EmployeeXML employeeXML) {
        EmployeeModel.EmployeeModelBuilder builder = new EmployeeModel.EmployeeModelBuilder();
        return builder
                .id(employeeXML.getId())
                .surname(employeeXML.getSurname())
                .name(employeeXML.getName())
                .patronymic(employeeXML.getPatronymic())
                .photo(employeeXML.getPhoto())
                .dateOfBirth(employeeXML.getDateOfBirth())
                .phoneNumber(employeeXML.getPhoneNumber())
                .organizationId(employeeXML.getOrganizationId())
                .departmentId(employeeXML.getDepartmentId())
                .positionId(employeeXML.getPositionId())
                .build();
    }

    public EmployeeJPA modelToJpa(EmployeeModel employeeModel) {
        EmployeeJPA.EmployeeJpaBuilder builder = new EmployeeJPA.EmployeeJpaBuilder();
        return builder
                .id(employeeModel.getId())
                .surname(employeeModel.getSurname())
                .name(employeeModel.getName())
                .patronymic(employeeModel.getPatronymic())
                .photo(employeeModel.getPhoto())
                .dateOfBirth(employeeModel.getDateOfBirth())
                .phoneNumber(employeeModel.getPhoneNumber())
                .build();
    }

    public EmployeeResponseDTO jpaToResponseDto(EmployeeJPA employeeJPA) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setSurname(employeeJPA.getSurname());
        employeeResponseDTO.setName(employeeJPA.getName());
        employeeResponseDTO.setPatronymic(employeeJPA.getPatronymic());
        employeeResponseDTO.setPhoto(employeeJPA.getPhoto());
        employeeResponseDTO.setDateOfBirth(employeeJPA.getDateOfBirth());
        employeeResponseDTO.setPhoneNumber(employeeJPA.getPhoneNumber());
        return employeeResponseDTO;
    }

    public EmployeeModel requestDtoToModel(EmployeeRequestDTO employeeRequestDTO) {
        EmployeeModel.EmployeeModelBuilder builder = new EmployeeModel.EmployeeModelBuilder();
        return builder
                .id(UUID.randomUUID())
                .surname(employeeRequestDTO.getSurname())
                .name(employeeRequestDTO.getName())
                .patronymic(employeeRequestDTO.getPatronymic())
                .photo(employeeRequestDTO.getPhoto())
                .dateOfBirth(employeeRequestDTO.getDateOfBirth())
                .phoneNumber(employeeRequestDTO.getPhoneNumber())
                .departmentId(employeeRequestDTO.getDepartmentId())
                .organizationId(employeeRequestDTO.getOrganizationId())
                .positionId(employeeRequestDTO.getPositionId())
                .build();
    }
}
