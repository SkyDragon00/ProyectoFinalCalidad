package com.proyecto.calidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * A simple in-memory implementation of the Repository interface.
 * This repository stores entities in a local list.
 * 
 * @param <T> the type of entities stored in this repository
 */
public class InMemoryRepository<T> implements Repository<T> {
    private static final Logger LOGGER = Logger.getLogger(InMemoryRepository.class.getName());

    /**
     * Internal list used to store entities.
     */
    private final List<T> storage;

    /**
     * Constructs a new InMemoryRepository with an empty list.
     */
    public InMemoryRepository() {
        this.storage = new ArrayList<>();
    }

    /**
     * Saves the given entity to the repository.
     *
     * @param entity the entity to be saved
     */
    @Override
    public void save(final T entity) {
        storage.add(entity);
        LOGGER.info("Entity saved: " + entity.toString());
    }

    /**
     * Returns an unmodifiable list of all stored entities.
     *
     * @return a list of all stored entities
     */
    @Override
    public List<T> findAll() {
        LOGGER.info("Retrieving all entities: " + storage.size() + " entities found.");
        return Collections.unmodifiableList(storage);
    }

    /**
     * Deletes the given entity from the repository.
     *
     * @param entity the entity to be deleted
     */
    @Override
    public void delete(final T entity) {
        storage.remove(entity);
        LOGGER.info("Entity deleted: " + entity.toString());
    }
}