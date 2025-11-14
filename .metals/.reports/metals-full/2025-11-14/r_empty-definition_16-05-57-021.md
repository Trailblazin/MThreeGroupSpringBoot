error id: file:///C:/Users/callu/mthree/MThreeGroupSpringBoot/src/main/java/org/example/services/TaskService.scala:findById.
file:///C:/Users/callu/mthree/MThreeGroupSpringBoot/src/main/java/org/example/services/TaskService.scala
empty definition using pc, found symbol in pc: findById.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -taskRepo/findById.
	 -taskRepo/findById#
	 -taskRepo/findById().
	 -scala/Predef.taskRepo.findById.
	 -scala/Predef.taskRepo.findById#
	 -scala/Predef.taskRepo.findById().
offset: 2068
uri: file:///C:/Users/callu/mthree/MThreeGroupSpringBoot/src/main/java/org/example/services/TaskService.scala
text:
```scala
package org.example.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.example.repositories.{TaskRepository, CategoryRepository}
import org.example.entities.{Task, Category}
import java.time.LocalDate
import java.util

@Service
class TaskService @Autowired()(taskRepo: TaskRepository, categoryRepo: CategoryRepository) {

  def getAll(): java.util.List[Task] =
    taskRepo.findAll()

  // return Java Optional so Java controller can use Optional<Task>
  def getById(id: Long): java.util.Optional[Task] =
    taskRepo.findById(id)

  def getByCategory(categoryId: Long) =
    taskRepo.findByCategoryId(categoryId)

  // Helpers to check if a value is empty (only handle concrete types you pass in)
  private def isEmptyValue(value: Any): Boolean = value match {
    case null => true
    case s: String => s.trim.isEmpty
    case _ => false
  }

  private def requireNonEmpty(value: Any, name: String): Unit = {
    if (isEmptyValue(value)) throw new RuntimeException(s"Task $name cannot be empty")
  }

  def create(task: Task): Task = {

    // use parentheses on Java getters
    requireNonEmpty(task.getTitle(), "title")
    requireNonEmpty(task.getDescription(), "description")

    requireNonEmpty(task.getDueDate(), "due date")
    if (task.getDueDate().isBefore(LocalDate.now()))
      throw new RuntimeException("Task due date cannot be in the past")

    requireNonEmpty(task.getPriority(), "priority")
    requireNonEmpty(task.isCompleted().asInstanceOf[Any], "completed")
    requireNonEmpty(task.getCategory(), "category")

    val cat = task.getCategory()
    if (cat == null || cat.getId == null)
      throw new RuntimeException("Category id missing")

    val category = categoryRepo.findById(cat.getId)
      .orElseThrow(() => new RuntimeException("Category not found"))

    task.setCategory(category)

    taskRepo.save(task)
  }

  def update(id: Long, task: Task): Task = {

    val existing = taskRepo.fin@@dById(id).orElseThrow(() => new RuntimeException("Task not found"))

    // keep old values if new is empty (call Java getters with parentheses)
    val title = if (isEmptyValue(task.getTitle())) existing.getTitle() else task.getTitle()
    val description = if (isEmptyValue(task.getDescription())) existing.getDescription() else task.getDescription()

    val dueDate = if (isEmptyValue(task.getDueDate())) existing.getDueDate() else {
      val d = task.getDueDate()
      if (d.isBefore(LocalDate.now())) throw new RuntimeException("Task due date cannot be in the past")
      d
    }

    val priority = if (isEmptyValue(task.getPriority())) existing.getPriority() else task.getPriority()
    val completed = if (isEmptyValue(task.isCompleted().asInstanceOf[Any])) existing.isCompleted() else task.isCompleted()

    val category = if (isEmptyValue(task.getCategory()) || (task.getCategory() != null && isEmptyValue(task.getCategory().getId.asInstanceOf[Any]))) {
      existing.getCategory()
    } else {
      categoryRepo.findById(task.getCategory().getId)
        .orElseThrow(() => new RuntimeException("Category not found"))
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

  // match Java controller method name
  def deleteById(id: Long): Unit =
    taskRepo.deleteById(id)

  def deleteAll(): Unit =
    taskRepo.deleteAll()
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: findById.