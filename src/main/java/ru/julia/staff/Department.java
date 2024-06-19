package ru.julia.staff;

import java.util.List;

/**
 * Класс описывает подразделение
 */
public class Department extends Staff {
    private String fullName;
    private String shortName;
    private Employee manager;
    private List<String> phoneNumbers;
}
