
package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.PositionResponseDTO;
import ru.julia.orm.jpamodel.PositionJPA;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.mapper.PositionMapper;
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
    private PositionMapper mapper;

    public void create(PositionModel positionModel) {
        positionRepository.save(mapper.modelToJpa(positionModel));
    }

    public PositionResponseDTO read(UUID id) {
        Optional<PositionJPA> positionJPA = positionRepository.findById(id);
        return positionJPA.map(positionJpa -> mapper.jpaToResponseDto(positionJpa))
                .orElseThrow(() -> new RuntimeException("Position with id " + id + " not found"));
    }

    public List<PositionResponseDTO> readAll() {
        List<PositionJPA> positionJPA = (List<PositionJPA>) positionRepository.findAll();
        List<PositionResponseDTO> positionResponseDTOS = new ArrayList<>();
        positionJPA.forEach(position -> positionResponseDTOS.add(mapper.jpaToResponseDto(position)));
        return positionResponseDTOS;
    }

    public void delete(UUID id) {
        positionRepository.deleteById(id);
    }
}

