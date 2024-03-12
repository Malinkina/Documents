package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.dto.request.OrganizationRequestDTO;
import ru.julia.dto.response.OrganizationResponseDTO;
import ru.julia.orm.jpamodel.OrganizationJPA;
import ru.julia.servicelayer.model.OrganizationModel;
import ru.julia.xml.xmlmodel.OrganizationXML;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class OrganizationMapper {
    public OrganizationModel xmlToModel(OrganizationXML organizationXML) {
        OrganizationModel.OrganizationModelBuilder builder = new OrganizationModel.OrganizationModelBuilder();
        return builder.id(organizationXML.getId())
                .fullName(organizationXML.getFullName())
                .shortName(organizationXML.getShortName())
                .manager(organizationXML.getManager())
                .phoneNumbers(organizationXML.getContactPhoneNumbers())
                .build();
    }

    public OrganizationJPA modelToJpa(OrganizationModel organizationModel) {
        OrganizationJPA.OrganizationJPABuilder builder = new OrganizationJPA.OrganizationJPABuilder();
        return builder
                .id(organizationModel.getId())
                .fullName(organizationModel.getFullName())
                .shortName(organizationModel.getShortName())
                .manager(organizationModel.getManager())
                .phoneNumbers(organizationModel.getPhoneNumbers().toString())
                .build();
    }

    public OrganizationModel requestDtoToModel(OrganizationRequestDTO organizationRequestDTO) {
        OrganizationModel.OrganizationModelBuilder builder = new OrganizationModel.OrganizationModelBuilder();
        return builder
                .id(UUID.randomUUID())
                .fullName(organizationRequestDTO.getFullName())
                .shortName(organizationRequestDTO.getShortName())
                .manager(organizationRequestDTO.getManager())
                .phoneNumbers(organizationRequestDTO.getContactPhoneNumbers())
                .build();
    }

    public OrganizationResponseDTO jpaToResponseDto(OrganizationJPA organizationJPA) {
        OrganizationResponseDTO organizationResponseDTO = new OrganizationResponseDTO();
        organizationResponseDTO.setFullName(organizationJPA.getFullName());
        organizationResponseDTO.setShortName(organizationJPA.getShortName());
        organizationResponseDTO.setManager(organizationJPA.getManager());
        String phoneNumbers = organizationJPA.getPhoneNumbers()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        List<String> contactPhoneNumbers = Arrays.asList(phoneNumbers.split(","));
        organizationResponseDTO.setContactPhoneNumbers(contactPhoneNumbers);
        return organizationResponseDTO;
    }
}
