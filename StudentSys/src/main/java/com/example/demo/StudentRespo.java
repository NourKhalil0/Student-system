package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespo extends JpaRepository<Students, Long> {

}
