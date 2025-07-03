package com.proyecto.calidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        Repository<TaskItem> repository = new InMemoryRepository<>();
        taskService = new TaskService(repository);
    }

    @Test
    void shouldAddTaskSuccessfully() {
        // Arrange
        TaskItem task = new TaskItem("Test Task");

        // Act
        taskService.addTask(task);

        // Assert
        List<TaskItem> tasks = taskService.listTasks();
        assertEquals(1, tasks.size(), "Task list size should be 1 after adding a task.");
        assertEquals("Test Task", tasks.get(0).getDescription(), "Task description should match the added task.");
    }

    @Test
    void shouldListAllTasksSuccessfully() {
        // Arrange
        TaskItem task1 = new TaskItem("Task 1");
        TaskItem task2 = new TaskItem("Task 2");
        taskService.addTask(task1);
        taskService.addTask(task2);

        // Act
        List<TaskItem> tasks = taskService.listTasks();

        // Assert
        assertEquals(2, tasks.size(), "Task list size should be 2 after adding two tasks.");
        assertEquals("Task 1", tasks.get(0).getDescription(), "First task description should match.");
        assertEquals("Task 2", tasks.get(1).getDescription(), "Second task description should match.");
    }

    @Test
    void shouldRemoveTaskSuccessfully() {
        // Arrange
        TaskItem task1 = new TaskItem("Task 1");
        TaskItem task2 = new TaskItem("Task 2");
        taskService.addTask(task1);
        taskService.addTask(task2);

        // Act
        taskService.removeTask(1); // Remove the first task

        // Assert
        List<TaskItem> tasks = taskService.listTasks();
        assertEquals(1, tasks.size(), "Task list size should be 1 after removing a task.");
        assertEquals("Task 2", tasks.get(0).getDescription(), "Remaining task should be 'Task 2'.");
    }

    @Test
    void shouldThrowExceptionWhenRemovingInvalidTask() {
        // Arrange
        TaskItem task = new TaskItem("Task 1");
        taskService.addTask(task);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> taskService.removeTask(2),
                "Should throw exception for invalid index.");
        assertEquals("Índice inválido.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    void shouldHandleEmptyTaskListGracefully() {
        // Act
        List<TaskItem> tasks = taskService.listTasks();

        // Assert
        assertTrue(tasks.isEmpty(), "Task list should be empty initially.");
    }
}