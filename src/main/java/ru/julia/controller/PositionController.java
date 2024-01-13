package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.domain.Position;
import ru.julia.service.PositionService;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Position position) {
        positionService.create(position);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Position> list() {
        return positionService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Position getById(@PathVariable("id") String id) {
        return positionService.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody Position position) {
        positionService.update(id, position);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        positionService.delete(id);
    }
}
