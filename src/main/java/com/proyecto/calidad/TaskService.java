package com.proyecto.calidad;

import java.util.List;

/**
 * Servicio que gestiona tareas mediante un repositorio.
 */
public class TaskService {
    /**
     * Repositorio que almacena elementos de tareas.
     */
    private final Repository<TaskItem> repo;

    /**
     * Crea una nueva instancia del servicio de tareas.
     * @param repo el repositorio a utilizar
     */
    public TaskService(final Repository<TaskItem> repo) {
        this.repo = repo;
    }

    /**
     * Agrega una nueva tarea al repositorio.
     * @param task la tarea a agregar
     */
    public void addTask(final TaskItem task) {
        repo.save(task);
    }

    /**
     * Devuelve la lista de tareas almacenadas.
     * @return lista de tareas
     */
    public List<TaskItem> listTasks() {
        return repo.findAll();
    }
}