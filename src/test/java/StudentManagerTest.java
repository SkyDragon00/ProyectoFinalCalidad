import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {
    private StudentManager sm;
    private ByteArrayOutputStream out;
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        sm = new StudentManager();
        out = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    void testAddStudentPrintsConfirmation() {
        sm.addStudent("John Doe", 85.5);
        assertEquals("Student added.", out.toString().trim());
    }

    @Test
    void testListStudentsShowsCorrectEntry() {
        sm.addStudent("John Doe", 85.5);
        out.reset();
        sm.listStudents();
        String printed = out.toString().trim();
        assertEquals("Student: John Doe, Grade: 85.5", printed);
    }
}