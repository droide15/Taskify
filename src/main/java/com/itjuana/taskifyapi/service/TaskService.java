package com.itjuana.taskifyapi.service;

import java.util.List;

import com.itjuana.taskifyapi.model.Task;
import com.itjuana.taskifyapi.repo.TaskRepo;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepo repo;

    // Constructor added for good practice and to remove the @Autowired annotation
    public TaskService(TaskRepo repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public void addTask(Task task) {
        repo.save(task);
    }

    public Task getTask(int id) {
        return repo.findById(id).orElse(null);
    }

    public void updateTask(Task task) {
        repo.save(task);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }
}
