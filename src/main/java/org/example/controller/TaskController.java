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

<<<<<<< HEAD
    @GetMapping("") // changed from "/tasks" to "" so endpoint is /tasks
    public ResponseEntity<List<Task>> allTasks()
    {
        List<Task> tasks = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
=======
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAll();
>>>>>>> 834ac00b39ea51d12930dd8d2abde1153e93a4e9
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return service.getById(id);
<<<<<<< HEAD

=======
    }

    @GetMapping("/category/{categoryId}")
    public List<Task> getTasksByCategory(@PathVariable Long categoryId) {
        return service.getByCategory(categoryId);
>>>>>>> 834ac00b39ea51d12930dd8d2abde1153e93a4e9
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.create(task);
    }

<<<<<<< HEAD
    @DeleteMapping("/{id}") // added mapping
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id)
    {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}") // added mapping
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task)
    {
        service.update(id, task);
        return new ResponseEntity<>(task, HttpStatus.OK);
=======
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.delete(id);
        return "Task deleted";
>>>>>>> 834ac00b39ea51d12930dd8d2abde1153e93a4e9
    }

    @DeleteMapping
    public String deleteAll() {
        service.deleteAll();
        return "All tasks deleted";
    }
}
