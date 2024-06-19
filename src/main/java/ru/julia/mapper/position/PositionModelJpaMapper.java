package ru.julia.mapper.position;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.PositionJpa;
import ru.julia.servicelayer.model.PositionModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionModelJpaMapper {
    PositionJpa toJpa(PositionModel positionModel);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJpaFromModel(PositionModel positionModel,
                            @MappingTarget PositionJpa positionJPA);
}
