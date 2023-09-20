package ru.julia;

import java.util.ArrayList;
import java.util.List;

public class RegNumbersStorage {
    private static final List<String> regNumbers = new ArrayList<>();
    public static List<String> getRegNumbers() {
        return regNumbers;
    }
}
