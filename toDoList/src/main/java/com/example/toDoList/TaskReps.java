package com.example.toDoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface TaskReps extends JpaRepository<Task, Long> {
    Optional<Task> getTaskById(Long id);
}
