package org.example.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.example.repositories.{TaskRepository, CategoryRepository}
import org.example.entities.{Task, Category}
import java.time.LocalDate
import org.example.exceptions.ApiException
import java.util

@Service
class TaskService @Autowired()(taskRepo: TaskRepository, categoryRepo: CategoryRepository) {

  def getAll(): util.List[Task] = taskRepo.findAll()


  def getById(id: Long): Task = {
    taskRepo.findById(id).orElseThrow(() => new ApiException("Task not found"))
  }

  // Helpers to check if a value is empty
  private def isEmptyValue(value: Any): Boolean = value match {
    case null => true
    case s: String => s.trim.isEmpty
    case _ =>false
  }

  private def requireNonEmpty(value: Any, name: String): Unit = {
    if (isEmptyValue(value)) throw new ApiException(s"Task $name cannot be empty")
  }

  def create(task: Task): Task = {


    requireNonEmpty(task.getTitle, "title")
    requireNonEmpty(task.getDescription, "description")

    requireNonEmpty(task.getDueDate, "due date")
    if (task.getDueDate.isBefore(LocalDate.now()))
      throw new ApiException("Task due date cannot be in the past")

    requireNonEmpty(task.getPriority, "priority")
    requireNonEmpty(task.isCompleted.asInstanceOf[Any], "completed")
    requireNonEmpty(task.getCategory, "category")

    val cat = task.getCategory
    if (cat == null || cat.getId == null)
      throw new ApiException("Category id missing")

    val category = categoryRepo.findById(cat.getId)
      .orElseThrow(() => new ApiException("Category not found"))


    task.setCategory(category)

    taskRepo.save(task)
  }

  def update(id: Long, task: Task): Task = {

    val existing: Task = taskRepo.findById(id).orElseThrow(() => new ApiException("Task not found"))


    //  keep old values if new is empty
    val title = if (isEmptyValue(task.getTitle)) existing.getTitle else task.getTitle
    val description = if (isEmptyValue(task.getDescription)) existing.getDescription else task.getDescription

    val dueDate = if (isEmptyValue(task.getDueDate)) existing.getDueDate else {
      val d = task.getDueDate
      if (d.isBefore(LocalDate.now())) throw new ApiException("Task due date cannot be in the past")
      d
    }

    val priority = if (isEmptyValue(task.getPriority)) existing.getPriority else task.getPriority
    val completed = if (isEmptyValue(task.isCompleted.asInstanceOf[Any])) existing.isCompleted else task.isCompleted

    // category: if incoming category or id is empty, keep existing; otherwise validate and set
    val category = if (isEmptyValue(task.getCategory) || isEmptyValue(task.getCategory.getId)) {
      existing.getCategory
    } else {
      categoryRepo.findById(task.getCategory.getId)
        .orElseThrow(() => new ApiException("Category not found"))
    }

    existing.setTitle(title)
    existing.setDescription(description)
    existing.setDueDate(dueDate)
    existing.setPriority(priority)
    existing.setCompleted(completed)
    existing.setCategory(category)
    existing.setId(id)

    taskRepo.save(existing)
  }

  def deleteById(id: Long): Unit =
    taskRepo.deleteById(id)

  def deleteAll(): Unit =
    taskRepo.deleteAll()
}
