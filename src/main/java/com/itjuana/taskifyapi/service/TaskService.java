package com.itjuana.taskifyapi.service;

import java.util.List;

import com.itjuana.taskifyapi.model.Task;
import com.itjuana.taskifyapi.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    public TaskRepo repo;

    public List<Task> getAllTasks() {
        return repo.getAllTasks();
    }

    public void addTask(Task task) {
        repo.addTask(task);
    }

    public Task getTask(int id) {

        return repo.getTask(id);
    }

    public void updateTask(Task task) {
        repo.updateTask(task);
    }

    public void deleteTask(int id) {
        repo.deleteTask(id);
    }
}
