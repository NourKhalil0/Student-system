package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Students> createStudent(@RequestBody Students student) {
        Students savedStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }


    @GetMapping
    public List<Students> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable Long id){
        Students students = studentService.getStudentById(id).
                orElseThrow(()->new NoSuchElementException("Student not found with id: " + id));
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudntById(@PathVariable Long id){
        try {
            studentService.deleteStudnetById(id);
            return ResponseEntity.ok("Student deleted with id: " + id);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Error..." +
                            "No such student found with id: " + id);
        }
    }
}
