package ru.julia.servicelayer;

import org.junit.jupiter.api.Test;
import ru.julia.exception.DocumentExistsException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegNumbersStorageTest {
    private static final String REG_NUMBER_1 = "regNumberOne";
    private static final String REG_NUMBER_2 = "regNumberTwo";
    private final RegNumbersStorage storage = new RegNumbersStorage();

    @Test
    void add() {
        assertDoesNotThrow(() -> storage.add(REG_NUMBER_1));
        assertTrue(storage.getRegNumbers().contains(REG_NUMBER_1));
    }

    @Test
    void addExistingRegNumber() {
        assertDoesNotThrow(() -> storage.add(REG_NUMBER_2));
        assertTrue(storage.getRegNumbers().contains(REG_NUMBER_2));
        assertThrows(DocumentExistsException.class, () -> storage.add(REG_NUMBER_2));
    }

    @Test
    void getRegNumbers() {
        List<String> regNumbers = storage.getRegNumbers();
        assertNotNull(regNumbers);
    }

    @Test
    void regNumbersUnmodified() {
        List<String> regNumbers = storage.getRegNumbers();
        assertThrows(UnsupportedOperationException.class, () -> regNumbers.add(REG_NUMBER_1));
    }
}