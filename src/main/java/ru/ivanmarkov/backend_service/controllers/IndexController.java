package ru.ivanmarkov.backend_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanmarkov.backend_service.entity.Task;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.service.TaskService;
import ru.ivanmarkov.backend_service.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    private UserService userService;
    private TaskService taskService;

    @Autowired
    public IndexController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    String index(){
        return "hello world";
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

    @GetMapping("/tasks")
    @ResponseBody
    List<Task> get_tasks(){
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskService.findAll()){
            tasks.add(task);
            System.out.println(task.getName());
        }
        return tasks;
    }
}
