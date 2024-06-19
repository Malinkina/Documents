
package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.mapper.position.PositionXmlModelMapper;
import ru.julia.servicelayer.service.PositionService;
import ru.julia.xml.XmlReader;

@Component
public class PositionTableFiller implements TableFiller, Ordered {
    @Autowired
    private XmlReader reader;
    @Autowired
    private PositionService service;
    @Autowired
    private PositionXmlModelMapper mapper;
    @Override
    public void fill() {
        reader
                .readPosition()
                .getPositions()
                .forEach(p -> service.create(mapper.toModel(p)));
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
