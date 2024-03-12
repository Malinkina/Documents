package ru.julia.servicelayer;

import org.springframework.stereotype.Component;
import ru.julia.exception.DocumentExistsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-хранилище регистрационных номеров
 */
@Component
public class RegNumbersStorage {
    private static final List<String> REG_NUMBERS = new ArrayList<>();

    public static void add(String regNumber) throws DocumentExistsException {
        if (!exists(regNumber)) {
            REG_NUMBERS.add(regNumber);
        } else {
            throw new DocumentExistsException();
        }
    }
    private static boolean exists(String regNumber) {
        return REG_NUMBERS.contains(regNumber);
    }
}
