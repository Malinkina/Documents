package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julia.mapper.position.PositionXmlModelMapper;
import ru.julia.servicelayer.model.PositionModel;
import ru.julia.servicelayer.service.PositionService;
import ru.julia.xml.XmlReader;
import ru.julia.xml.xmlmodel.PositionXml;
import ru.julia.xml.xmlmodel.wrapper.PositionWrapper;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PositionTableFillerTest {
    @Mock
    private XmlReader reader;
    @Mock
    private PositionService service;
    @Mock
    private PositionXmlModelMapper mapper;
    @InjectMocks
    private PositionTableFiller tableFiller;

    @Test
    void fill() {
        PositionWrapper wrappedPosition = new PositionWrapper();
        when(reader.readPosition()).thenReturn(wrappedPosition);
        List<PositionXml> positions = wrappedPosition.getPositions();
        PositionXml positionXml = new PositionXml();
        positions.add(positionXml);
        positions.add(positionXml);
        PositionModel positionModel = new PositionModel();
        when(mapper.toModel(positionXml)).thenReturn(positionModel);
        tableFiller.fill();
        verify(reader, times(1)).readPosition();
        verify(mapper, times(positions.size())).toModel(positionXml);
        verify(service, times(positions.size())).create(positionModel);
    }

    @Test
    void getOrder() {
        int order = tableFiller.getOrder();
        Assertions.assertEquals(3, order);
    }
}