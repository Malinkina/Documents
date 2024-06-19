package ru.julia.dao;

public interface MyDAO<T> {

    T getById(String id);
}
