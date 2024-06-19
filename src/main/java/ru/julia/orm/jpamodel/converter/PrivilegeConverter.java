package ru.julia.orm.jpamodel.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.julia.servicelayer.model.Privilege;

@Converter(autoApply = true)
public class PrivilegeConverter implements AttributeConverter<Privilege, String> {
    @Override
    public String convertToDatabaseColumn(Privilege privilege) {
        return privilege.getValue();
    }

    @Override
    public Privilege convertToEntityAttribute(String privilege) {
        return Privilege.getValueOf(privilege);
    }
}
