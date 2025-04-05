package com.example.toDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication {

	@Autowired
	private static TaskReps taskReps;
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);


	}

}
