package com.example.school_sms_.web.rest;


import com.example.school_sms_.dao.Student;
import com.example.school_sms_.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String  getListOfStudents(Model model){
        RestTemplate restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students";
        ResponseEntity<Student[]> response=restTemplate.getForEntity(URL,Student[].class);
        model.addAttribute("students",response.getBody());
        return "students"; // students file name
    }
    @GetMapping("/add-page")
    public String getAddForm(){
        return  "add-student";
    }
    @GetMapping("/edit-page")
    public String getEditForm(HttpServletRequest request,Model model){
        RestTemplate restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students/{id}";
       Student student= restTemplate.getForObject(URL,Student.class,request.getParameter("id"));
       model.addAttribute("student",student);
       return "/edit-stud-form";// got this page
    }
    @PostMapping("/create")
    public String addStudent(String firstname,String lastname,String year,Integer age){
        RestTemplate restTemplate=new RestTemplate();
        StudentDto studentDto= new StudentDto(firstname,lastname,year,age);
        String URL="http://localhost:2022/api/students";
        restTemplate.postForEntity(URL,studentDto,Student.class);
        return  "redirect:/students";
    }
    @PostMapping("/edit")
    public String editStudent(String firstname,String lastname,String year,Integer age,HttpServletRequest request){
        RestTemplate restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students/{id}";
        StudentDto studentDto= new StudentDto(firstname,lastname,year,age);
        restTemplate.put(URL,studentDto,request.getParameter("id"));
        return "redirect:/students";

    }
    @GetMapping("/delete")
    public String deleteStudent(HttpServletRequest request){
        System.out.println("deletteetetete");
        RestTemplate  restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students/{id}";
        restTemplate.delete(URL,request.getParameter("id"));
        return "redirect:/students";
    }

}
