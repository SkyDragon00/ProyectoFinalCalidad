import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager tm;
    private ByteArrayOutputStream out;
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        tm = new TaskManager();
        out = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    void testAddAndListTasks() {
        tm.addTask("Do homework");
        assertEquals("Task added.", out.toString().trim());

        out.reset();
        tm.listTasks();
        String printed = out.toString().trim();
        assertEquals("Task 1: Do homework", printed);
    }

    @Test
    void testRemoveTaskThenListIsEmpty() {
        tm.addTask("Cleanup");
        out.reset();
        tm.removeTask(1);
        assertEquals("Task removed.", out.toString().trim());

        out.reset();
        tm.listTasks();
        assertEquals("", out.toString().trim());
    }

    @Test
    void testRemoveInvalidTaskThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> tm.removeTask(1));
    }
}