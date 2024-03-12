package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.dto.request.PositionRequestDTO;
import ru.julia.dto.response.PositionResponseDTO;
import ru.julia.orm.jpamodel.PositionJPA;
import ru.julia.servicelayer.model.PositionModel;
import ru.julia.xml.xmlmodel.PositionXML;

import java.util.UUID;

@Component
public class PositionMapper {
    public PositionModel xmlToModel(PositionXML positionXML) {
        PositionModel.PositionModelBuilder builder = new PositionModel.PositionModelBuilder();
        return builder
                .id(positionXML.getId())
                .positionId(positionXML.getPositionId())
                .name(positionXML.getName())
                .build();
    }

    public PositionJPA modelToJpa(PositionModel positionModel) {
        PositionJPA.PositionJpaBuilder builder = new PositionJPA.PositionJpaBuilder();
        return builder
                .id(positionModel.getId())
                .positionId(positionModel.getPositionId())
                .name(positionModel.getName())
                .build();
    }

    public PositionModel requestDtoToModel(PositionRequestDTO positionRequestDTO) {
        PositionModel.PositionModelBuilder builder = new PositionModel.PositionModelBuilder();
        return builder
                .id(UUID.randomUUID())
                .positionId((int) (Math.random() * 100))
                .name(positionRequestDTO.getName())
                .build();
    }

    public PositionResponseDTO jpaToResponseDto(PositionJPA positionJPA) {
        PositionResponseDTO positionResponseDTO = new PositionResponseDTO();
        positionResponseDTO.setName(positionJPA.getName());
        return positionResponseDTO;
    }
}
