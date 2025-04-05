package com.example.toDoList;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    Task task = new Task();
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id).
                orElseThrow(() -> new NoSuchElementException("Task not found with id: " + id));
                return ResponseEntity.ok(task);

    }

    @PostMapping
    public void createTask(@RequestBody Task task){
        try {
            taskService.createTask(task);
            System.out.println("Task created at: " + task.getCreatedAt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task){
        if (id == null){
            Logger logger = Logger.getLogger("Err");
            logger.info("Id not found");
        }else {
            taskService.updateTask(id, task);
            System.out.println("Task updated");
        }
    }
    @DeleteMapping("/{id}")
    public void deleteTask(Long id){
        if (id == null){
            Logger logger = Logger.getLogger("Err");
            logger.info("Id not found");
        }else {
            taskService.deleteTask(id);
            System.out.println("Task deleted");
        }
    }
}
