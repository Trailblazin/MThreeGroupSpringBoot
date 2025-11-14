package org.example.controller;

import org.example.entities.Task;
import org.example.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("") // changed from "/tasks" to "" so endpoint is /tasks
    public ResponseEntity<List<Task>> allTasks()
    {
        List<Task> tasks = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return service.getById(id);

    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = service.create(task); // let service throw its validation RuntimeExceptions
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

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
    }

}
