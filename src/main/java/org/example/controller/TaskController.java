package org.example.controller;

import org.example.repositories.CategoryRepository;
import org.example.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {



    @Autowired
    TaskRepository tasks;
}
