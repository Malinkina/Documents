package ru.julia.staff;

import java.util.List;

/**
 * Класс описывает персонал
 */
public class Employee extends Staff {
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private Position position;
    private String dateOfBirth;
    private List<String> phoneNumbers;
}
