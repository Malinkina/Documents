
package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.PositionJPA;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.service.mapper.PositionMapper;
import ru.julia.service.modelforservice.PositionModel;

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

    public Optional<PositionJPA> read(UUID id) {
        return positionRepository.findById(id);
    }

    public List<PositionJPA> readAll() {
        return (List<PositionJPA>) positionRepository.findAll();
    }

    public void delete(UUID id) {
        positionRepository.deleteById(id);
    }
}

