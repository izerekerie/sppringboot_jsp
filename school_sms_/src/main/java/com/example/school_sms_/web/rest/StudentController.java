package com.example.school_sms_.web.rest;
import com.example.school_sms_.dao.Student;
import com.example.school_sms_.dto.StudentDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String  getListOfStudents(Model model,HttpServletRequest request){

        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        RestTemplate restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students";
       // ResponseEntity<Student[]> response=restTemplate.getForEntity(URL,Student[].class);
       ResponseEntity<Student[]> response=restTemplate.exchange("http://localhost:2022/api/students",HttpMethod.GET, entity,Student[].class);
        System.out.println(response.getBody());
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
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        HttpEntity<String> entity=new HttpEntity<String>(headers);
     //   RestTemplate restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students/{id}";
     //  Student student= restTemplate.exchange(URL,Student.class,entity,HttpMethod.GET,request.getParameter("id"),Student.class);
        ResponseEntity<Student> response=restTemplate.exchange(URL,HttpMethod.GET, entity,Student.class,request.getParameter("id"));

        model.addAttribute("student",response.getBody());
       return "/edit-stud-form";// got this page
    }
    @PostMapping("/create")
    public String addStudent(String firstname, String lastname, String year, Integer age, HttpServletRequest request){
        RestTemplate restTemplate=new RestTemplate();
       // StudentDto studentDto= new StudentDto(firstname,lastname,year,age);
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        Map<String,Object> map = new HashMap<>();
        map.put("firstname",firstname);
        map.put("lastname",lastname);
        map.put("year",year);
        map.put("age",age);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);

        String URL="http://localhost:2022/api/students";
        restTemplate.postForEntity(URL,entity,Student.class);
        return  "redirect:/students";
    }
    @PostMapping("/edit")
    public String editStudent(String firstname,String lastname,String year,Integer age,HttpServletRequest request){
        RestTemplate restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students/{id}";
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        Map<String,Object> map = new HashMap<>();
        map.put("firstname",firstname);
        map.put("lastname",lastname);
        map.put("year",year);
        map.put("age",age);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
        restTemplate.put(URL,entity,request.getParameter("id"));
        return "redirect:/students";

    }
    @GetMapping("/delete")
    public String deleteStudent(HttpServletRequest request){

        RestTemplate  restTemplate=new RestTemplate();
        String URL="http://localhost:2022/api/students/{id}";
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);

        HttpEntity<String> entity=new HttpEntity<String>(headers);
        restTemplate.exchange(URL,HttpMethod.DELETE,entity,String.class,request.getParameter("id"));
        return "redirect:/students";
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
