package ru.julia.exception;

import lombok.NoArgsConstructor;

/**
 * Класс обработки исключения, когда документ с данным регистрационным номером уже существует
 */

@NoArgsConstructor
public class DocumentExistsException extends Exception {
    public DocumentExistsException(String message) {
        super(message);
    }
}
