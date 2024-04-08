package ru.julia.mapper.position;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.orm.jpamodel.PositionJpa;
import ru.julia.servicelayer.model.PositionModel;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PositionModelJpaMapperTest {
    private static final PositionModelJpaMapper MAPPER = Mappers.getMapper(PositionModelJpaMapper.class);
    private static final UUID ID_MODEL = UUID.fromString("c8b0161e-0af7-4789-88a2-47f783540cb4");
    private static final int POSITION_ID_MODEL = 123;
    private static final String NAME_MODEL = "Position1";
    private static final UUID ID_JPA = UUID.fromString("27c11279-2341-418e-a4c3-ef182aacf8c3");
    private static final int POSITION_ID_JPA = 321;
    private static final String NAME_JPA = "Position2";

    @Test
    void toJpa() {
        PositionModel model = createPositionModel();
        PositionJpa jpa = MAPPER.toJpa(model);
        assertEquals(ID_MODEL, jpa.getId());
        assertEquals(POSITION_ID_MODEL, jpa.getPositionId());
        assertEquals(NAME_MODEL, jpa.getName());
    }

    @Test
    void updateJpaFromModel_whenAllFields_thenAllMapped() {
        PositionModel model = createPositionModel();
        PositionJpa jpa = createPositionJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID_MODEL, jpa.getId());
        assertEquals(POSITION_ID_MODEL, jpa.getPositionId());
        assertEquals(NAME_MODEL, jpa.getName());
    }

    @Test
    void updateJpaFromModel_whenOneField_thenOnlyOneFieldMapped() {
        PositionModel model = new PositionModel();
        model.setId(ID_MODEL);
        model.setName(NAME_MODEL);
        PositionJpa jpa = createPositionJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID_MODEL, jpa.getId());
        assertEquals(POSITION_ID_JPA, jpa.getPositionId());
        assertEquals(NAME_MODEL, jpa.getName());
    }

    @Test
    void updateJpaFromModel_whenNull_thenNotMapped() {
        PositionModel model = createPositionModel();
        model.setName(null);
        PositionJpa jpa = createPositionJpa();
        MAPPER.updateJpaFromModel(model, jpa);
        assertEquals(ID_MODEL, jpa.getId());
        assertEquals(POSITION_ID_MODEL, jpa.getPositionId());
        assertNotNull(jpa.getName());
    }

    private static PositionModel createPositionModel() {
        PositionModel model = new PositionModel();
        model.setId(ID_MODEL);
        model.setPositionId(POSITION_ID_MODEL);
        model.setName(NAME_MODEL);
        return model;
    }

    private static PositionJpa createPositionJpa() {
        PositionJpa jpa = new PositionJpa();
        jpa.setId(ID_JPA);
        jpa.setPositionId(POSITION_ID_JPA);
        jpa.setName(NAME_JPA);
        return jpa;
    }
}