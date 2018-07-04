package ru.ivanmarkov.backend_service.service;

import ru.ivanmarkov.backend_service.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void create(User user);
    User update(User user);
    void deleteById(int id);
}
