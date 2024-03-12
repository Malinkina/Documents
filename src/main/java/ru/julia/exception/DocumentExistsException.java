package ru.julia.exception;

/**
 * Класс обработки исключения, когда документ с данным регистрационным номером уже существует
 */
public class DocumentExistsException extends Exception {
    public DocumentExistsException() {}
}
