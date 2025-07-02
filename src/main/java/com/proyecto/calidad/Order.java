package com.proyecto.calidad;


public class Order {
    private final String customer;
    private final String item;

    public Order(String customer, String item) {
        this.customer = customer;
        this.item = item;
    }

    public String getCustomer() { return customer; }
    public String getItem() { return item; }

    @Override
    public String toString() {
        return customer + " -> " + item;
    }
}
