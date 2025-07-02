import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {
    private OrderManager om;
    private ByteArrayOutputStream out;
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        om = new OrderManager();
        out = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    void testAddOrderPrintsConfirmation() {
        om.addOrder("Alice", "Laptop");
        assertEquals("Order added for Alice", out.toString().trim());
    }

    @Test
    void testListOrdersShowsCorrectEntry() {
        om.addOrder("Alice", "Laptop");
        om.addOrder("Bob", "Phone");
        out.reset();
        om.listOrders();
        String printed = out.toString();
        assertTrue(printed.contains("Customer: Alice, Order: Laptop"));
        assertTrue(printed.contains("Customer: Bob, Order: Phone"));
    }
}