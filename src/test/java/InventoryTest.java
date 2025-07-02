import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;
    private ByteArrayOutputStream out;
    private PrintStream originalOut;

    @BeforeEach
    void init() {
        inventory = new Inventory();
        out = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

    @Test
    void testAddProductPrintsConfirmation() {
        inventory.addProduct("Laptop", 5, 1000.0);
        String printed = out.toString().trim();
        assertEquals("Product added.", printed);
    }

    @Test
    void testPrintInventoryShowsOneProduct() {
        inventory.addProduct("Laptop", 5, 1000.0);
        out.reset();
        inventory.printInventory();
        String printed = out.toString().trim();
        assertTrue(printed.contains("Product: Laptop, Quantity: 5, Price: $1000.0"));
    }

    @Test
    void testMultipleProductsListed() {
        inventory.addProduct("Phone", 2, 500.0);
        inventory.addProduct("Tablet", 3, 300.0);
        out.reset();
        inventory.printInventory();
        String printed = out.toString();
        assertTrue(printed.contains("Phone") && printed.contains("Tablet"));
    }
}