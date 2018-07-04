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
            if (taskRepository.findById(id).isPresent()) {
                return taskRepository.findById(id).get();
            } else {
                return null;
            }
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
        if (taskRepository.findById(task_id).isPresent()) {
            return taskRepository.findById(task_id).get().getUser();
        } else {
            return null;
        }
    }

    @Override
    public Task update(Task task) {
        try{
            if (taskRepository.findById(task.getId()).isPresent()){
                Task old_task = taskRepository.findById(task.getId()).get();
                old_task.setName(task.getName());
                old_task.setDescription(task.getDescription());
                old_task.setDeadline(task.getDeadline());
                return taskRepository.save(old_task);
            } else {
                return null;
            }
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void delete(int id) {
        try{
            taskRepository.deleteById(id);
        }catch (NoSuchElementException e){
            System.out.println("nothing");
        }
    }
}
