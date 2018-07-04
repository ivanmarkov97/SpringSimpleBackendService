package ru.ivanmarkov.backend_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ivanmarkov.backend_service.entity.Task;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.service.TaskService;
import ru.ivanmarkov.backend_service.service.UserService;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TaskController {

    private TaskService taskService;
    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
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

    @PostMapping("/tasks/create")
    @ResponseBody
    void create_task(@RequestBody Map<String, String> jsonRow){
        try {
            int user_id = Integer.parseInt(jsonRow.get("user"));
            User user = userService.findById(user_id);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date created_at = formatter.parse(jsonRow.get("created_at"));
            Date deadline = formatter.parse(jsonRow.get("deadline"));
            Task task = new Task(
                    jsonRow.get("name"),
                    jsonRow.get("description"),
                    created_at,
                    deadline,
                    user
            );
            taskService.create(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/tasks")
    @ResponseBody
    Task update_task(@RequestBody Task task){
        return taskService.update(task);
    }

}
