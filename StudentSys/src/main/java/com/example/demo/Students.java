package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Students {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String first_name;
    String last_name;
    Date birthDate;
    String study_program;

    public void setId(Long id) {
        this.id = id;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setStudy_program(String study_program) {
        this.study_program = study_program;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getStudy_program() {
        return study_program;
    }
}
