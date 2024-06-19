package ru.julia.staff;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Employee extends Staff {
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    private Position position;
    private String dateOfBirth;
    private List<String> phoneNumbers;
}
