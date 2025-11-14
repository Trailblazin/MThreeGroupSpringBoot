package org.example.controller;

import org.example.entities.Task;
import org.example.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Task> getTasksByCategory(@PathVariable Long categoryId) {
        return service.getByCategory(categoryId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.delete(id);
        return "Task deleted";
    }

    @DeleteMapping
    public String deleteAll() {
        service.deleteAll();
        return "All tasks deleted";
    }
}
