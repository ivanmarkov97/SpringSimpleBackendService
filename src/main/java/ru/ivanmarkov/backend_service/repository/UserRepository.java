package ru.ivanmarkov.backend_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivanmarkov.backend_service.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
