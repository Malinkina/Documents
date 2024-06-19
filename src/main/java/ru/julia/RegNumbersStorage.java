package ru.julia;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-хранилище регистрационных номеров
 */
@Component
public class RegNumbersStorage {
    private static final List<String> regNumbers = new ArrayList<>();
    public List<String> getRegNumbers() {
        return regNumbers;
    }
}
