package com.itjuana.taskifyapi.repo;

import java.util.ArrayList;
import java.util.List;

import com.itjuana.taskifyapi.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepo {

    List<Task> tasks = new ArrayList<>();

    public TaskRepo() {
        tasks.add(new Task(1, "Prepare infraestructure", "Prepare the infraestructure", "Completed"));

        tasks.add(new Task(2, "Install equipement", "Install the equipement", "Pending"));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    public void updateTask(Task task) {
        for (Task currentTask : tasks) {
            if (currentTask.getId() == task.getId()) {
                currentTask.setTitle(task.getTitle());
                currentTask.setDescription(task.getDescription());
                currentTask.setStatus(task.getStatus());
            }
        }
    }

    public void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
            }
        }
    }
}
