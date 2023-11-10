package ru.julia.dao;

public interface MyDAO<T> {

    T getById(String id);

    void update(String column, String value);

    void delete(T t);
}
