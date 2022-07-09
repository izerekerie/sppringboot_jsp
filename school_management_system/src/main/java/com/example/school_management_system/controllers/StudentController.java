package com.example.school_management_system.controllers;

import com.example.school_management_system.dto.StudentDto;
import com.example.school_management_system.models.Student;
import com.example.school_management_system.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    StudentServices studentServices;
    @GetMapping
    public List<Student> getAllStudents(){
        return studentServices.getAllStudents();
    }
    @GetMapping("/{id}")
    public HttpEntity<Student> getOneStudent(@PathVariable Long id){
        return studentServices.getStudentById(id);
    }
    @PostMapping
    public  Student createStudent(@RequestBody StudentDto stud){
        return studentServices.insertStudent(stud);
    }
    @PutMapping ("/{id}")
    public HttpEntity<Student> updateStudent(@RequestBody StudentDto student, @PathVariable Long id){
        System.out.println("User "+student.getFirstname()+" id"+id);
        return  studentServices.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public  HttpEntity<Student> deleteStudent(@PathVariable Long id){
        return  studentServices.deleteStudentById(id);
    }
}
