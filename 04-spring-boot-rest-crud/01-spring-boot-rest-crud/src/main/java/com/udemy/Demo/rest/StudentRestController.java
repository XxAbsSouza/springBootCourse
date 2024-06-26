package com.udemy.Demo.rest;

import com.udemy.Demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @postConstructor to load the student data ...

    @PostConstruct
    private  void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Uri", "Abreu"));
        theStudents.add(new Student("Dulce", "Maria"));
        theStudents.add(new Student("Benjie", "Levandarte"));
        theStudents.add(new Student("Ana", "Bia"));
    }
    //define endpoint for "/Students" - return a lsit of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoint or "/students/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list .. keep it simple for now

        //check student id again list size
        if((studentId>= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);

    }

}
