package org.example.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.example.repositories.{TaskRepository, CategoryRepository}
import org.example.entities.Task

@Service
class TaskService @Autowired()(taskRepo: TaskRepository, categoryRepo: CategoryRepository) {

  def getAll() = taskRepo.findAll()

  def getById(id: Long) =
    taskRepo.findById(id).orElseThrow(() => new RuntimeException("Task not found"))

  def getByCategory(categoryId: Long) =
    taskRepo.findByCategoryId(categoryId)

  def create(task: Task): Task = {

    val cat = task.getCategory
    if (cat == null || cat.getId == null)
      throw new RuntimeException("Category id missing")

    val category = categoryRepo.findById(cat.getId)
      .orElseThrow(() => new RuntimeException("Category not found"))

    task.setCategory(category)

    taskRepo.save(task)
  }

  def update(id: Long, task: Task): Task = {

    val existing = getById(id)

    existing.setTitle(task.getTitle)
    existing.setDescription(task.getDescription)
    existing.setPriority(task.getPriority)
    existing.setCompleted(task.isCompleted)
    existing.setDueDate(task.getDueDate)

    val category = categoryRepo.findById(task.getCategory.getId)
      .orElseThrow(() => new RuntimeException("Category not found"))

    existing.setCategory(category)

    taskRepo.save(existing)
  }

  def delete(id: Long): Unit =
    taskRepo.deleteById(id)

  def deleteAll(): Unit =
    taskRepo.deleteAll()
}
