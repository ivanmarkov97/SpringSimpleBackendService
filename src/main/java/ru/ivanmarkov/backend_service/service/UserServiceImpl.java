package ru.ivanmarkov.backend_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        try {
            if (userRepository.findById(id).isPresent()) {
                return userRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        try {
            if (userRepository.findById(user.getId()).isPresent()) {
                User update_user = userRepository.findById(user.getId()).get();
                update_user.setName(user.getName());
                update_user.setEmail(user.getEmail());
                return userRepository.save(update_user);
            } else {
                return null;
            }
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            userRepository.deleteById(id);
        } catch (NoSuchElementException e){
            System.out.println("nothing");
        }
    }
}
