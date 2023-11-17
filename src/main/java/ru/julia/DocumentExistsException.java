package ru.julia;

/**
 * Класс обработки исключение, когда документ с данным регистрационным номером уже существует
 */
public class DocumentExistsException extends Exception {
    public DocumentExistsException() {}
}
