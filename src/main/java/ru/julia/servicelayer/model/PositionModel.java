package ru.julia.servicelayer.model;

import java.util.UUID;

public class PositionModel {
    private UUID id;
    private int positionId;
    private String name;

    private PositionModel() {}

    public UUID getId() {
        return id;
    }

    public int getPositionId() {
        return positionId;
    }

    public String getName() {
        return name;
    }
    public static class PositionModelBuilder {
        private PositionModel positionModel = new PositionModel();
        public PositionModelBuilder id(UUID id) {
            positionModel.id = id;
            return this;
        }
        public PositionModelBuilder positionId(int id) {
            positionModel.positionId = id;
            return this;
        }
        public PositionModelBuilder name(String name) {
            positionModel.name = name;
            return this;
        }
        public PositionModel build() {
            return positionModel;
        }
    }
}
