package org.example.controller;

import org.example.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryController
{
    @Autowired
    CategoryRepository categories;
}
