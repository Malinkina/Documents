
package ru.julia.servicelayer.service;

import org.springframework.stereotype.Component;
import ru.julia.controller.dto.response.PositionResponseDto;
import ru.julia.mapper.position.PositionJpaResponseDtoMapper;
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
    private final PositionRepository positionRepository;
    private final PositionModelJpaMapper modelJpaMapper;
    private final PositionJpaResponseDtoMapper jpaResponseDtoMapper;

    public PositionService(PositionRepository positionRepository,
                           PositionModelJpaMapper modelJpaMapper,
                           PositionJpaResponseDtoMapper jpaResponseDtoMapper) {
        this.positionRepository = positionRepository;
        this.modelJpaMapper = modelJpaMapper;
        this.jpaResponseDtoMapper = jpaResponseDtoMapper;
    }

    public void create(PositionModel positionModel) {
        if (positionModel.getId() == null) {
            positionModel.setId(UUID.randomUUID());
            positionModel.setPositionId((int) (Math.random() * 100));
        }
        positionRepository.save(modelJpaMapper.toJpa(positionModel));
    }

    public PositionResponseDto read(UUID id) {
        Optional<PositionJpa> positionJpa = positionRepository.findById(id);
        return positionJpa.map(jpaResponseDtoMapper::toResponseDto)
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

