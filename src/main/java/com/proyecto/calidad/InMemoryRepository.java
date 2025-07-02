package com.proyecto.calidad;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryRepository<T> implements Repository<T> {

    private final List<T> storage = new ArrayList<>();

    @Override
    public void save(T entity) {
        storage.add(entity);
    }

    @Override
    public List<T> findAll() {
        return Collections.unmodifiableList(storage);
    }
}
