package com.itjuana.taskifyapi.controller;

import com.itjuana.taskifyapi.model.Task;
import com.itjuana.taskifyapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("health")
    public String health() {
        return "working";
    }

    @GetMapping("tasks")
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping("task")
    public Task addTask(@Valid @RequestBody Task task) {
        service.addTask(task);
        return service.getTask(task.getId());
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable int id) {
        return service.getTask(id);
    }

    @PutMapping("task")
    public Task updateTask(@Valid @RequestBody Task task) {
        service.updateTask(task);
        return service.getTask(task.getId());
    }

    @DeleteMapping("task/{id}")
    public String deleteTask(@PathVariable int id)
    {
        service.deleteTask(id);
        return "Deleted";
    }
}
