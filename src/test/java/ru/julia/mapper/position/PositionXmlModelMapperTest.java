package ru.julia.mapper.position;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.servicelayer.model.PositionModel;
import ru.julia.xml.xmlmodel.PositionXml;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionXmlModelMapperTest {
    private static final PositionXmlModelMapper MAPPER = Mappers.getMapper(PositionXmlModelMapper.class);
    private static final UUID ID = UUID.fromString("c8b0161e-0af7-4789-88a2-47f783540cb4");
    private static final int POSITION_ID = 123;
    private static final String NAME = "Position";

    @Test
    void toModel() {
        PositionXml xml = new PositionXml();
        xml.setId(ID);
        xml.setPositionId(POSITION_ID);
        xml.setName(NAME);
        PositionModel model = MAPPER.toModel(xml);
        assertEquals(ID, model.getId());
        assertEquals(POSITION_ID, model.getPositionId());
        assertEquals(NAME, model.getName());
    }
}