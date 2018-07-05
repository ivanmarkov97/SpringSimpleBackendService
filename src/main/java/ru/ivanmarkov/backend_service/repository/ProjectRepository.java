package ru.ivanmarkov.backend_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanmarkov.backend_service.entity.Project;
import ru.ivanmarkov.backend_service.entity.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
