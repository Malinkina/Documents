package ru.julia.mapper.position;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.servicelayer.model.PositionModel;
import ru.julia.xml.xmlmodel.PositionXml;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionXMLModelMapper {
    PositionModel toModel(PositionXml positionXML);
}
