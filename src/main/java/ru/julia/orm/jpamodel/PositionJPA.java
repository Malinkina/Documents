package ru.julia.orm.jpamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "position")
public class PositionJPA {
    @Id
    private UUID id;
    @Column(name = "position_id")
    private int positionId;
    private String name;

    public UUID getId() {
        return id;
    }

    public int getPositionId() {
        return positionId;
    }

    public String getName() {
        return name;
    }

    public static class PositionJpaBuilder {
        private PositionJPA positionJPA = new PositionJPA();

        public PositionJpaBuilder id(UUID id) {
            positionJPA.id = id;
            return this;
        }

        public PositionJpaBuilder positionId(int positionId) {
            positionJPA.positionId = positionId;
            return this;
        }

        public PositionJpaBuilder name(String name) {
            positionJPA.name = name;
            return this;
        }

        public PositionJPA build() {
            return positionJPA;
        }
    }
}
