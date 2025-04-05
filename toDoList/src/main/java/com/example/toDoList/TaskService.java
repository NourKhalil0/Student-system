package com.example.toDoList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    Task task = new Task();
  private final TaskReps taskReps;

  @Autowired
  public TaskService(TaskReps taskReps){
      this.taskReps = taskReps;
  }

    public List<Task> getTasks(){
        return taskReps.findAll();
    }

    public Optional<Task> getTaskById(Long id){
      return taskReps.findById(id);
    }
    public Task createTask(Task task){
      task.setCreatedAt(LocalDateTime.now());
      task.setUpdatedAt(LocalDateTime.now());

      return taskReps.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setDueDate(updatedTask.getDueDate());
        task.setDone(updatedTask.isDone());
        task.setUpdatedAt(LocalDateTime.now());
        return taskReps.save(task);
    }
    public void deleteTask(Long id){
      taskReps.deleteById(id);
    }
}

