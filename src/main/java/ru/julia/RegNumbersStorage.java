package ru.julia;

import org.springframework.stereotype.Component;
import ru.julia.document.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-хранилище регистрационных номеров
 */
@Component
public class RegNumbersStorage {
    private static final List<String> REG_NUMBERS = new ArrayList<>();

    public void add(Document document) throws DocumentExistsException {
        if (!exists(document.getRegNumber())) {
            REG_NUMBERS.add(document.getRegNumber());
        } else {
            throw new DocumentExistsException();
        }
    }
    private boolean exists(String regNumber) {
        return REG_NUMBERS.contains(regNumber);
    }
}
