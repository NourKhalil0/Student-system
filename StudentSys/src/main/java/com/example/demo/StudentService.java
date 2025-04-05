package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    Students students = new Students();
    private final StudentRespo studentRespo;


    @Autowired
    public StudentService(StudentRespo studentRespo) {
        this.studentRespo = studentRespo;
    }
    public Students save(Students student) {
        return studentRespo.save(student);
    }

    public List<Students> getAllStudents(){
        return studentRespo.findAll();
    }
    public Optional<Students> getStudentById(Long id){

        return studentRespo.findById(id);
    }

    public Students updateStudent(Long id, Students updatedStudent) {

        Students student = studentRespo.findById(id).orElse(null);
          if (student == null) {
            throw new NoSuchElementException("Student not found with id: " + id);
        }
        student.setFirst_name(updatedStudent.getFirst_name());
        student.setLast_name(updatedStudent.getLast_name());
        student.setBirthDate(updatedStudent.getBirthDate());
        student.setStudy_program(updatedStudent.getStudy_program());
        return studentRespo.save(student);
    }


    public void deleteStudnetById(Long id){
        if (studentRespo.existsById(id)){
            studentRespo.deleteById(id);
            System.out.println("Student deleted with id: " + id);
        }
    }
}
