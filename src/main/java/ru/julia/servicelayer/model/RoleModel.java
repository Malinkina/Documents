package ru.julia.servicelayer.model;

import java.util.List;

public record RoleModel(String code, List<Privilege> privileges) {
}
