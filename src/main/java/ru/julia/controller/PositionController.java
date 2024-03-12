package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.PositionRequestDTO;
import ru.julia.dto.response.PositionResponseDTO;
import ru.julia.servicelayer.service.PositionService;
import ru.julia.mapper.PositionMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService service;
    @Autowired
    private PositionMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PositionRequestDTO positionRequestDTO) {
        service.create(mapper.requestDtoToModel(positionRequestDTO));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PositionResponseDTO> list() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionResponseDTO getById(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    /*@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody PositionJPA position) {
        service.update(id, position);
    }*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
