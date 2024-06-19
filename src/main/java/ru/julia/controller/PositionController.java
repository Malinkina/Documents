package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.PositionRequestDto;
import ru.julia.controller.dto.response.PositionResponseDto;
import ru.julia.mapper.position.PositionRequestDtoModelMapper;
import ru.julia.servicelayer.service.PositionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService service;
    @Autowired
    private PositionRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('CREATE_POSITION')")
    public UUID create(@Valid @RequestBody PositionRequestDto positionRequestDto) {
        return service.create(mapper.toModel(positionRequestDto));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_POSITION')")
    public List<PositionResponseDto> readALl() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_POSITION')")
    public PositionResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_POSITION')")
    public void update(@PathVariable("id") UUID id, @RequestBody PositionRequestDto positionRequestDto) {
        service.update(id, mapper.toModel(positionRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('DELETE_POSITION')")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
