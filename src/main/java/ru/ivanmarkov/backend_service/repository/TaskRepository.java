package ru.ivanmarkov.backend_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanmarkov.backend_service.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
