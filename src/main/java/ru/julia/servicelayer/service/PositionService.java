
package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.PositionResponseDto;
import ru.julia.mapper.position.PositionJpaResponseDTOMapper;
import ru.julia.mapper.position.PositionModelJpaMapper;
import ru.julia.orm.jpamodel.PositionJpa;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.servicelayer.model.PositionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PositionModelJpaMapper modelJpaMapper;
    @Autowired
    private PositionJpaResponseDTOMapper jpaResponseDtoMapper;

    public void create(PositionModel positionModel) {
        if (positionModel.getId() == null) {
            positionModel.setId(UUID.randomUUID());
            positionModel.setPositionId((int) (Math.random()*100));
        }
        positionRepository.save(modelJpaMapper.toJpa(positionModel));
    }

    public PositionResponseDto read(UUID id) {
        Optional<PositionJpa> positionJpa = positionRepository.findById(id);
        return positionJpa.map(position -> jpaResponseDtoMapper.toResponseDto(position))
                .orElseThrow(() -> new RuntimeException("Position with id %s not found".formatted(id)));
    }

    public List<PositionResponseDto> readAll() {
        List<PositionJpa> positionJpa = (List<PositionJpa>) positionRepository.findAll();
        List<PositionResponseDto> positionResponseDtos = new ArrayList<>();
        positionJpa.forEach(position -> positionResponseDtos.add(jpaResponseDtoMapper.toResponseDto(position)));
        return positionResponseDtos;
    }

    public void update(UUID id, PositionModel positionModel) {
        PositionJpa existingPosition = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position with id %s not found".formatted(id)));
        modelJpaMapper.updateJpaFromModel(positionModel, existingPosition);
        positionRepository.save(existingPosition);
    }

    public void delete(UUID id) {
        positionRepository.deleteById(id);
    }
}

