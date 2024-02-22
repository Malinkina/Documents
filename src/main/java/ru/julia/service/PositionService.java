
package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPAPosition;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.service.mapper.PositionMapper;
import ru.julia.service.modelforservice.PositionModel;
import ru.julia.xml.xmlmodel.XMLPosition;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PositionMapper mapper;

    public void create(PositionModel positionModel) {
        positionRepository.save(mapper.positionModelToJpaPosition(positionModel));
    }

    public Optional<JPAPosition> read(UUID id) {
        return positionRepository.findById(id);
    }

    public List<JPAPosition> readAll() {
        return (List<JPAPosition>) positionRepository.findAll();
    }

    public void delete(UUID id) {
        positionRepository.deleteById(id);
    }
    private JPAPosition mapData(XMLPosition xmlPosition) {
        JPAPosition JPAPositionForDb = new JPAPosition();
        JPAPositionForDb.setId(UUID.fromString(xmlPosition.getId()));
        JPAPositionForDb.setPositionId(xmlPosition.getPositionId());
        JPAPositionForDb.setName(xmlPosition.getName());
        return JPAPositionForDb;
    }
}

