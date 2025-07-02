package com.proyecto.calidad;


import java.util.List;

public class StudentService {
    private final Repository<Student> repo;

    public StudentService(Repository<Student> repo) {
        this.repo = repo;
    }

    public void addStudent(Student student) {
        repo.save(student);
    }

    public List<Student> listStudents() {
        return repo.findAll();
    }
}
