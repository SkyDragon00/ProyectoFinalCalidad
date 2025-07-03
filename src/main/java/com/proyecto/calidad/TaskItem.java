package com.proyecto.calidad;

/**
 * Represents a task with a textual description.
 */
public class TaskItem {

    /** The textual description of the task. */
    private final String description;

    /**
     * Constructs a new task with the specified description.
     * @param description the description of the task
     */
    public TaskItem(final String description) {
        this.description = description;
    }

    /**
     * Returns the description of the task.
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the string representation of the task.
     * @return the description string
     */
    @Override
    public String toString() {
        return description;
    }
}
