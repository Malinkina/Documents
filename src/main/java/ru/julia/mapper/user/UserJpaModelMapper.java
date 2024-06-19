package ru.julia.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.orm.jpamodel.RoleJpa;
import ru.julia.orm.jpamodel.UserJpa;
import ru.julia.servicelayer.model.Privilege;
import ru.julia.servicelayer.model.UserModel;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserJpaModelMapper {
    @Mapping(source = "role", target = "authorities", qualifiedByName = "getAuthoritiesFromRole")
    UserModel toModel (UserJpa userJpa);

    @Named("getAuthoritiesFromRole")
    default List<Privilege> getAuthoritiesFromRole(RoleJpa role) {
        return role.getPrivileges();
    }
}
