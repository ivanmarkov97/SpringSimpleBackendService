package ru.ivanmarkov.backend_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.service.UserService;

import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/users/{id}")
    @ResponseBody
    User get_user(@PathVariable("id") int id){
        System.out.println(id);
        return userService.findById(id);
    }

    @PostMapping("/users/create")
    void create_user(@RequestBody User user){
        user.setCreate_date(new Date());
        userService.create(user);
    }

    @PutMapping("/users")
    @ResponseBody
    User update_user(@RequestBody User user){
        return userService.update(user);
    }
}
