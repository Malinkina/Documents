package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.PositionRequestDto;
import ru.julia.dto.response.PositionResponseDto;
import ru.julia.mapper.position.PositionRequestDTOModelMapper;
import ru.julia.servicelayer.service.PositionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService service;
    @Autowired
    private PositionRequestDTOModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody PositionRequestDto positionRequestDto) {
        service.create(mapper.toModel(positionRequestDto));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PositionResponseDto> readALl() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") UUID id, @RequestBody PositionRequestDto positionRequestDto) {
        service.update(id, mapper.toModel(positionRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
