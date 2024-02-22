package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.PositionJPA;
import ru.julia.service.modelforservice.PositionModel;
import ru.julia.xml.xmlmodel.PositionXML;
@Component
public class PositionMapper {
    public PositionModel xmlPositionToPositionModel(PositionXML positionXML) {
        PositionModel.PositionModelBuilder builder = new PositionModel.PositionModelBuilder();
        return builder
                .id(positionXML.getId())
                .positionId(positionXML.getPositionId())
                .name(positionXML.getName())
                .build();
    }

    public PositionJPA positionModelToJpaPosition(PositionModel positionModel) {
        PositionJPA.PositionJpaBuilder builder = new PositionJPA.PositionJpaBuilder();
        return builder
                .id(positionModel.getId())
                .positionId(positionModel.getPositionId())
                .name(positionModel.getName())
                .build();
    }
}
