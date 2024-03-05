package ru.julia;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-хранилище регистрационных номеров
 */
@Component
public class RegNumbersStorage {
    private static final List<String> REG_NUMBERS = new ArrayList<>();

    public void add(String regNumber) throws DocumentExistsException {
        if (!exists(regNumber)) {
            REG_NUMBERS.add(regNumber);
        } else {
            throw new DocumentExistsException();
        }
    }
    private boolean exists(String regNumber) {
        return REG_NUMBERS.contains(regNumber);
    }
}
