
package ru.julia.dbconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.service.PositionService;
import ru.julia.service.mapper.PositionMapper;
import ru.julia.xml.XMLReader;

@Component
public class PositionTableFiller {
    @Autowired
    private XMLReader reader;
    @Autowired
    private PositionService service;
    @Autowired
    private PositionMapper mapper;
    public void fillPosition() {
        reader
                .readPosition()
                .getPositions()
                .forEach(p -> service.create(mapper.xmlPositionToPositionModel(p)));
    }
}
