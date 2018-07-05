package ru.ivanmarkov.backend_service.service;

import ru.ivanmarkov.backend_service.entity.Project;
import ru.ivanmarkov.backend_service.entity.User;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(int id);
    void create(Project task);
    User getUser(int project_id);
    Project update(Project task);
    void delete(int id);
}
