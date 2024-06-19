package ru.julia.staff;

import java.util.List;

/**
 * Класс описывает организацию
 */
public class Organization extends Staff {
    private String fullName;
    private String shortName;
    private Employee manager;
    private List<String> phoneNumbers;
}
