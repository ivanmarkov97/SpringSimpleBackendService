package ru.ivanmarkov.backend_service.service;

import ru.ivanmarkov.backend_service.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(int id);
}
