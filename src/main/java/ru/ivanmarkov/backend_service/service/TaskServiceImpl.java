package ru.ivanmarkov.backend_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivanmarkov.backend_service.entity.Task;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.repository.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) {
        try {
            return taskRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    @Transactional
    public void create(Task task) {
        taskRepository.save(task);
    }

    @Override
    public User getUser(int task_id) {
        return taskRepository.getOne(task_id).getUser();
    }
}
