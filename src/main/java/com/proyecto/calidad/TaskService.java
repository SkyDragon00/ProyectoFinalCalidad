package com.proyecto.calidad;


import java.util.List;

public class TaskService {
    private final Repository<Task> repo;

    public TaskService(Repository<Task> repo) {
        this.repo = repo;
    }

    public void addTask(Task task) { repo.save(task); }

    public List<Task> listTasks() { return repo.findAll(); }
}
