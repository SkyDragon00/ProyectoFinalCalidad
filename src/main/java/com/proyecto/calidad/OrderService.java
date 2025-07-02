package com.proyecto.calidad;


import java.util.List;

public class OrderService {
    private final Repository<Order> repo;

    public OrderService(Repository<Order> repo) {
        this.repo = repo;
    }

    public void addOrder(Order order) {
        repo.save(order);
    }

    public List<Order> listOrders() {
        return repo.findAll();
    }
}
