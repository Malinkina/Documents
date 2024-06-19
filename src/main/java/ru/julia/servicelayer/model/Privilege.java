package ru.julia.servicelayer.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Stream;

@Getter
public enum Privilege implements GrantedAuthority {
    DOCUMENT_READ("READ_DOCUMENT"),
    DOCUMENT_CREATE("CREATE_DOCUMENT"),
    DOCUMENT_UPDATE("UPDATE_DOCUMENT"),
    DOCUMENT_DELETE("DELETE_DOCUMENT"),
    ORGANIZATION_READ("READ_ORGANIZATION"),
    ORGANIZATION_CREATE("CREATE_ORGANIZATION"),
    ORGANIZATION_UPDATE("UPDATE_ORGANIZATION"),
    ORGANIZATION_DELETE("DELETE_ORGANIZATION"),
    DEPARTMENT_READ("READ_DEPARTMENT"),
    DEPARTMENT_CREATE("CREATE_DEPARTMENT"),
    DEPARTMENT_UPDATE("UPDATE_DEPARTMENT"),
    DEPARTMENT_DELETE("DELETE_DEPARTMENT"),
    POSITION_READ("READ_POSITION"),
    POSITION_CREATE("CREATE_POSITION"),
    POSITION_UPDATE("UPDATE_POSITION"),
    POSITION_DELETE("DELETE_POSITION"),
    EMPLOYEE_READ("READ_EMPLOYEE"),
    EMPLOYEE_CREATE("CREATE_EMPLOYEE"),
    EMPLOYEE_UPDATE("UPDATE_EMPLOYEE"),
    EMPLOYEE_DELETE("DELETE_EMPLOYEE");

    private final String value;
    Privilege(String value) {
        this.value = value;
    }

    public static Privilege getValueOf(String privilege) {
        return Stream.of(Privilege.values())
                .filter(priv -> priv.getValue().equals(privilege))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String getAuthority() {
        return value;
    }
}