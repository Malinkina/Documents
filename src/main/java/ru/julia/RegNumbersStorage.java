package ru.julia;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-хранилище регистрационных номеров
 */
public class RegNumbersStorage {
    private static final List<String> regNumbers = new ArrayList<>();
    private static volatile RegNumbersStorage instance;

    private RegNumbersStorage() {
    }

    public static RegNumbersStorage getInstance() {
        if (instance == null) {
            synchronized (Report.class) {
                if (instance == null) {
                    instance = new RegNumbersStorage();
                }
            }
        }
        return instance;
    }
    public List<String> getRegNumbers() {
        return regNumbers;
    }
}
