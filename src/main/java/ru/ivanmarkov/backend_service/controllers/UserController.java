package ru.ivanmarkov.backend_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    List<User> get_users(){
        List<User> users = new ArrayList<>();
        for (User user: userService.findAll()) {
            users.add(user);
            System.out.println(user.getName());
        }
        return users;
    }
}
