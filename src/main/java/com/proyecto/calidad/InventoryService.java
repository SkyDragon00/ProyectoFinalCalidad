package com.proyecto.calidad;


import java.util.List;

public class InventoryService {
    private final Repository<Product> repo;

    public InventoryService(Repository<Product> repo) {
        this.repo = repo;
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public List<Product> listProducts() {
        return repo.findAll();
    }
}
