package ru.ivanmarkov.backend_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivanmarkov.backend_service.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
