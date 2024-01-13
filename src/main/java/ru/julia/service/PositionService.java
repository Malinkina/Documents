package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.PositionDAO;
import ru.julia.domain.Position;

import java.util.List;

@Component
public class PositionService {
    @Autowired
    private PositionDAO positionDAO;

    public void create(Position position) {
        positionDAO.create(position);
    }

    public Position read(String id) {
        return positionDAO.read(id);
    }

    public List<Position> readAll() {
        return positionDAO.readAll();
    }

    public void update(String id, Position position) {
        positionDAO.update(id, position);
    }

    public void delete(String id) {
        positionDAO.delete(id);
    }
}
