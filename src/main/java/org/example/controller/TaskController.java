package org.example.controller;

import org.example.entities.Task;
import org.example.repositories.CategoryRepository;
import org.example.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> allTasks()
    {
        List<Task> tasks = taskRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id)
    {
        Task task = (Task) taskRepo.findById(id).orElse(null);

        if (task == null) {
            return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<Void> addNewTask(@RequestBody Task task)
    {
        taskRepo.save(task);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id)
    {
        taskRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody Task task)
    {
        taskRepo.save(task);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

}
