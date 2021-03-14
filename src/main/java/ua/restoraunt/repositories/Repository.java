package ua.restoraunt.repositories;

import java.util.List;


public interface Repository<T> {
    T create(T entity);

    void delete(int id);

    T update(T entity);

    T get(int id);

    List<T> getAll();
}
