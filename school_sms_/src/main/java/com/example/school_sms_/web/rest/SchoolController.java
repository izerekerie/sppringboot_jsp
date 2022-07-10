package com.example.school_sms_.web.rest;
import com.example.school_sms_.dao.School;
import com.example.school_sms_.dto.SchoolDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/schools")
public class SchoolController {
    @GetMapping
    public String getListOfSchool(Model model){

        ResponseEntity<School[]> response= new RestTemplate().
                getForEntity("http://localhost:2022/api/schools",School[].class);

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
       School school = restTemplate.getForObject(URL,School.class,request.getParameter("id"));
       model.addAttribute("school",school);
        return "edit-form";
   }
    @PostMapping("/create")
    public String add(String name,String address){
        System.out.println("here we are");
      //  School
        SchoolDto dto=new SchoolDto(name,address);
        ResponseEntity<School> schoolResponseEntity=new RestTemplate()
                .postForEntity("http://localhost:2022/api/schools",dto,School.class);
        return "redirect:/";
    }
    @PostMapping("/edit")
    public  String edit(String name,String address,HttpServletRequest request){
        SchoolDto dto = new SchoolDto(name,address);
        String URL = "http://localhost:2022/api/schools/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(URL,dto,request.getParameter("id"));
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){

        RestTemplate restTemplate =  new RestTemplate();
        String URL ="http://localhost:2022/api/schools/{id}";
        restTemplate.delete(URL,request.getParameter("id"));
           return  "redirect:/";

    }
}
