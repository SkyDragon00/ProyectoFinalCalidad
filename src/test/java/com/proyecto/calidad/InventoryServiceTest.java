package com.proyecto.calidad;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTest {

    @Test
    void addAndListProduct() {
        Repository<Product> repo = new InMemoryRepository<>();
        InventoryService service = new InventoryService(repo);
        Product p = new Product("P1", "Laptop", 5, 1000.0);
        service.addProduct(p);
        List<Product> products = service.listProducts();
        assertEquals(1, products.size());
        assertTrue(products.contains(p));
    }
}
