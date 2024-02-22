package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPAPosition;
import ru.julia.service.modelforservice.PositionModel;
import ru.julia.xml.xmlmodel.XMLPosition;

import java.util.UUID;
@Component
public class PositionMapper {
    public PositionModel xmlPositionToPositionModel(XMLPosition xmlPosition) {
        PositionModel positionModel = new PositionModel();
        positionModel.setId(UUID.fromString(xmlPosition.getId()));
        positionModel.setPositionId(xmlPosition.getPositionId());
        positionModel.setName(xmlPosition.getName());
        return positionModel;
    }

    public JPAPosition positionModelToJpaPosition(PositionModel positionModel) {
        JPAPosition jpaPosition = new JPAPosition();
        jpaPosition.setId(positionModel.getId());
        jpaPosition.setPositionId(positionModel.getPositionId());
        jpaPosition.setName(positionModel.getName());
        return jpaPosition;
    }
}
