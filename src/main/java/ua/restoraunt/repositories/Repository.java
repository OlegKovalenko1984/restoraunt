package ua.restoraunt.repositories;

import java.util.List;


public interface Repository<T> {
    long create(T entity);

    void delete(int id);

    long update(T entity);

    T get(int id);

    List<T> getAll();
}
