
package ru.julia.service.dbinitiator.dbfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.service.PositionService;
import ru.julia.service.mapper.PositionMapper;
import ru.julia.xml.XMLReader;

@Component
public class PositionTableFiller implements TableFiller {
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
                .forEach(p -> service.create(mapper.xmlPositionToPositionModel(p)));
    }
}
