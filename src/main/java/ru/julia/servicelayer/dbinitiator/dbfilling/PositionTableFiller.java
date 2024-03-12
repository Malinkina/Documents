
package ru.julia.servicelayer.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.service.PositionService;
import ru.julia.mapper.PositionMapper;
import ru.julia.xml.XMLReader;

@Component
public class PositionTableFiller implements TableFiller, Ordered {
    @Autowired
    private XMLReader reader;
    @Autowired
    private PositionService service;
    @Autowired
    private PositionMapper mapper;
    @Override
    public void fill() {
        reader
                .readPosition()
                .getPositions()
                .forEach(p -> service.create(mapper.xmlToModel(p)));
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
