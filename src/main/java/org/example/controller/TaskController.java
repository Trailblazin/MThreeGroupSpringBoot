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
        List<Task> tasks = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id)
    {
        Optional<Task> opt = service.findById(id);
        if (opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = service.create(task); // let service throw its validation RuntimeExceptions
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}") // added mapping
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id)
    {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}") // added mapping
    public ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody Task task)
    {
        service.update(id, task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

}
