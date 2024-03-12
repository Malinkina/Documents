package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.dto.request.DepartmentRequestDTO;
import ru.julia.dto.response.DepartmentResponseDTO;
import ru.julia.orm.jpamodel.DepartmentJPA;
import ru.julia.servicelayer.model.DepartmentModel;
import ru.julia.xml.xmlmodel.DepartmentXML;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DepartmentMapper {
    public DepartmentModel xmlToModel(DepartmentXML departmentXML) {
        DepartmentModel.DepartmentModelBuilder builder = new DepartmentModel.DepartmentModelBuilder();
        return builder
                .id(departmentXML.getId())
                .fullName(departmentXML.getFullName())
                .shortName(departmentXML.getShortName())
                .manager(departmentXML.getManager())
                .phoneNumbers(departmentXML.getContactPhoneNumbers())
                .organizationId(departmentXML.getOrganizationId())
                .build();
    }
    public DepartmentJPA modelToJpa(DepartmentModel departmentModel) {
        DepartmentJPA.DepartmentJpaBuilder builder = new DepartmentJPA.DepartmentJpaBuilder();
        return builder
                .id(departmentModel.getId())
                .fullName(departmentModel.getFullName())
                .shortName(departmentModel.getShortName())
                .manager(departmentModel.getManager())
                .phoneNumbers(departmentModel.getPhoneNumbers().toString())
                .build();
    }

    public DepartmentModel requestDtoToModel(DepartmentRequestDTO departmentRequestDTO) {
        DepartmentModel.DepartmentModelBuilder builder = new DepartmentModel.DepartmentModelBuilder();
        return builder
                .id(UUID.randomUUID())
                .fullName(departmentRequestDTO.getFullName())
                .shortName(departmentRequestDTO.getShortName())
                .manager(departmentRequestDTO.getManager())
                .phoneNumbers(departmentRequestDTO.getContactPhoneNumbers())
                .organizationId(departmentRequestDTO.getOrganizationId())
                .build();
    }

    public DepartmentResponseDTO jpaToResponseDto(DepartmentJPA departmentJPA) {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setFullName(departmentJPA.getFullName());
        departmentResponseDTO.setShortName(departmentJPA.getShortName());
        departmentResponseDTO.setManager(departmentJPA.getManager());
        String phoneNumbers = departmentJPA.getPhoneNumbers()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        List<String> contactPhoneNumbers = Arrays.asList(phoneNumbers.split(","));
        departmentResponseDTO.setContactPhoneNumbers(contactPhoneNumbers);
        return departmentResponseDTO;
    }
}
