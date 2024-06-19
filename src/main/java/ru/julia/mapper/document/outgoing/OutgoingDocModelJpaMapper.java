package ru.julia.mapper.document.outgoing;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.OutgoingDocJpa;
import ru.julia.servicelayer.model.OutgoingDocModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OutgoingDocModelJpaMapper {
    OutgoingDocJpa toJpa(OutgoingDocModel outgoingDocModel);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJpaFromModel(OutgoingDocModel outgoingDocModel, @MappingTarget OutgoingDocJpa outgoingDocJpa);
}
