package com.proyecto.calidad;

import java.util.List;

/**
 * Service class that manages the inventory of products.
 */
public class InventoryService {

    /** Repository used for storing and retrieving products. */
    private final Repository<Product> repo;

    /**
     * Constructs a new InventoryService with the given repository.
     *
     * @param repo the repository used to store and retrieve products
     */
    public InventoryService(final Repository<Product> repo) {
        this.repo = repo;
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product the product to add
     */
    public void addProduct(final Product product) {
        repo.save(product);
    }

    /**
     * Returns a list of all products in the inventory.
     *
     * @return list of products
     */
    public List<Product> listProducts() {
        return repo.findAll();
    }
}
