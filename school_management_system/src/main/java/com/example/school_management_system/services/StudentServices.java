package com.example.school_management_system.services;


import com.example.school_management_system.dto.StudentDto;
import com.example.school_management_system.models.School;
import com.example.school_management_system.models.Student;
import com.example.school_management_system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    StudentRepository studentRepository;
   public List<Student> getAllStudents(){

       return  studentRepository.findAll();
   }
   public Student insertStudent(StudentDto student){
       Student newStudent=new Student(student);
       return studentRepository.save(newStudent);

   }
   public ResponseEntity<Student> getStudentById(Long id){
       Optional<Student> optionalStudent=studentRepository.findById(id);
       if(optionalStudent.isEmpty()){
         return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
      // return new  ResponseEntity<>(HttpStatus.OK,optionalStudent);
       return  new ResponseEntity<>(optionalStudent.get(),HttpStatus.OK);
   }
 public   ResponseEntity<Student>  deleteStudentById(Long id){
       Optional<Student> optionalStudent=studentRepository.findById(id);
       if(optionalStudent.isEmpty()){
           return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
      studentRepository.deleteById(optionalStudent.get().getId());
       return new ResponseEntity<>(HttpStatus.OK);
 }

 public ResponseEntity<Student> updateStudent(Long id,StudentDto student){
       Optional<Student> optionalStudent=studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
               return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         Student updatedStudent=new Student();
        updatedStudent.setId(id);
        updatedStudent.setFirstname(student.getFirstname());
        updatedStudent.setLastname(student.getLastname());
        updatedStudent.setYear(student.getYear());
        updatedStudent.setAge(student.getAge());


     return  new ResponseEntity<>(studentRepository.save(updatedStudent),HttpStatus.OK);
 }

}
