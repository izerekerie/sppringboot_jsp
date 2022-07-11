package com.example.school_sms_.web.rest;
import com.example.school_sms_.dao.School;
import com.example.school_sms_.dao.Student;
import com.example.school_sms_.dto.SchoolDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/schools")
public class SchoolController {
    @GetMapping
    public String getListOfSchool(Model model,HttpServletRequest request){
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        RestTemplate restTemplate=new RestTemplate();
        headers.set("Authorization",token);
        HttpEntity<String> entity=new HttpEntity<String>(headers);

        String URL=   "http://localhost:2022/api/schools";
               // getForEntity(",School[].class);
                //        ResponseEntity<School[]> response= new RestTemplate();
        ResponseEntity<School[]> response=restTemplate.exchange(URL,HttpMethod.GET,entity,School[].class);
        model.addAttribute("schools",response.getBody());
        return "schools";// file name
    }

    @GetMapping("/add-page")
    public String addPageForm(){
        return "form";
    }

   @GetMapping("/edit-page")
   public String editPageForm(HttpServletRequest request,Model model){
       RestTemplate restTemplate = new RestTemplate();
       String URL = "http://localhost:2022/api/schools/{id}";
       String token=request.getSession().getAttribute("token").toString();
       HttpHeaders headers=getHeaders();
       headers.set("Authorization",token);
       HttpEntity<String> entity=new HttpEntity<String>(headers);
      // School school = restTemplate.getForObject(URL,School.class,request.getParameter("id"));
       ResponseEntity<School> response=restTemplate.exchange(URL,HttpMethod.GET, entity,School.class,request.getParameter("id"));;
      // ResponseEntity<Student> response=restTemplate.exchange(URL,HttpMethod.GET, entity,Student.class,request.getParameter("id"));
       model.addAttribute("school",response.getBody());
        return "edit-form";
   }
    @PostMapping("/create")
    public String add(String name,String address,HttpServletRequest request){
        System.out.println("here we are");
        RestTemplate restTemplate=new RestTemplate();
        // StudentDto studentDto= new StudentDto(firstname,lastname,year,age);
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("address",address);

        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
      //  SchoolDto dto=new SchoolDto(name,address);

        ResponseEntity<School> schoolResponseEntity=new RestTemplate()
                .postForEntity("http://localhost:2022/api/schools",entity,School.class);
        return "redirect:/schools";
    }
    @PostMapping("/edit")
    public  String edit(String name,String address,HttpServletRequest request){
       // SchoolDto dto = new SchoolDto(name,address);
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("address",address);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
        String URL = "http://localhost:2022/api/schools/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(URL,entity,request.getParameter("id"));
        return "redirect:/schools";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        String token=request.getSession().getAttribute("token").toString();
        HttpHeaders headers=getHeaders();
        headers.set("Authorization",token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate =  new RestTemplate();
        String URL ="http://localhost:2022/api/schools/{id}";
        restTemplate.exchange(URL,HttpMethod.DELETE,entity,String.class,request.getParameter("id"));
           return  "redirect:/schools";

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
