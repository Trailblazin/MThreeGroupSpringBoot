error id: file:///C:/Users/callu/mthree/MThreeGroupSpringBoot/src/main/java/org/example/services/TaskService.scala:`<none>`.
file:///C:/Users/callu/mthree/MThreeGroupSpringBoot/src/main/java/org/example/services/TaskService.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -task.
	 -task#
	 -task().
	 -scala/Predef.task.
	 -scala/Predef.task#
	 -scala/Predef.task().
offset: 1185
uri: file:///C:/Users/callu/mthree/MThreeGroupSpringBoot/src/main/java/org/example/services/TaskService.scala
text:
```scala
package org.example.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.example.entities.Task
import org.example.repositories.TaskRepository.taskRepo
import org.example.exceptions.ApiException

//Abstract service trait defining task operations

def findAll(): List[Task]
def findById(id: Long): Option[Task]
def create(task: Task): Task
def update(id: Long, task: Task): Task
def delete(id: Long): Unit


@Service
class TaskService @Autowired()(val taskRepo: TaskRepository) {

    def findAll(): List[Task] ={
    taskRepo.findAll().toList
    }

    def findById(id: Long): Option[Task] ={
    try {
        taskRepo.findById(id).toOption
    } catch {
        case _: ApiException => "No Such Task".toOption
    }
    }

    def create(task: Task): Task ={
        if (task.title == null || task.title.trim.isEmpty) {
            throw new ApiException("Task title cannot be empty")
        }else if(task.description==null||task.description.trim.isEmpty){
            throw new ApiException("Task description cannot be empty")

        }else if(task.dueDate==null || @@task.dueDate.before(new java.util.Date())){
            throw new ApiException("Task due date cannot be in the past")
        }else if(task.category==null || task.category.trim.isEmpty){
            throw new ApiException("Task category cannot be empty")
        }

        taskRepo.save(task).orElseThrow(() => new ApiException("Task could not be created"))
    }

    def update(id: Long, task: Task): Task ={

        val existingTask = taskRepo.findById(id).orElseThrow(() => new ApiException("Task not found"))
        val updatedTask = existingTask.copy(
            title = task.title,
            description = task.description,
            completed = task.completed
        )
        taskRepo.save(updatedTask)
    }

    def delete(id: Long): Unit ={
        taskRepo.deleteById(id).orElseThrow(() => new ApiException("Task not found"))
    }
   
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.