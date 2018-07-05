package ru.ivanmarkov.backend_service.service;

import ru.ivanmarkov.backend_service.entity.Project;
import ru.ivanmarkov.backend_service.entity.Task;
import ru.ivanmarkov.backend_service.entity.User;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(int id);
    void create(Task task);
    Project getProject(int project_id);
    Task update(Task task);
    void delete(int id);
}
