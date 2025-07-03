package com.proyecto.calidad;

import java.util.List;
import java.util.logging.Logger;

/**
 * Servicio que gestiona tareas mediante un repositorio.
 */
public class TaskService {
    private static final Logger LOGGER = Logger.getLogger(TaskService.class.getName());

    /**
     * Repositorio que almacena elementos de tareas.
     */
    private final Repository<TaskItem> repo;

    /**
     * Crea una nueva instancia del servicio de tareas.
     * 
     * @param repo el repositorio a utilizar
     */
    public TaskService(final Repository<TaskItem> repo) {
        if (repo == null) {
            throw new IllegalArgumentException("Repository cannot be null.");
        }
        this.repo = repo; // Ensure repo is not shared externally
    }

    /**
     * Agrega una nueva tarea al repositorio.
     * 
     * @param task la tarea a agregar
     */
    public void addTask(final TaskItem task) {
        repo.save(task);
        LOGGER.info("Task added: " + task.getDescription());
    }

    /**
     * Devuelve la lista de tareas almacenadas.
     * 
     * @return lista de tareas
     */
    public List<TaskItem> listTasks() {
        List<TaskItem> tasks = repo.findAll();
        LOGGER.info("Listing tasks: " + tasks.size() + " tasks found.");
        return tasks;
    }

    /**
     * Elimina una tarea por su índice.
     * 
     * @param index el índice de la tarea a eliminar
     */
    public void removeTask(final int index) {
        List<TaskItem> tasks = repo.findAll();
        if (index > 0 && index <= tasks.size()) {
            TaskItem taskToRemove = tasks.get(index - 1);
            repo.delete(taskToRemove);
            LOGGER.info("Task removed: " + taskToRemove.getDescription());
        } else {
            LOGGER.warning("Invalid index: " + index);
            throw new IllegalArgumentException("Índice inválido.");
        }
    }
}