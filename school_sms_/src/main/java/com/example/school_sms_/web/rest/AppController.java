package com.example.school_sms_.web.rest;

import com.example.school_sms_.dao.School;
import com.example.school_sms_.dto.LoginDTO;
import com.example.school_sms_.dto.SchoolDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AppController {
    @GetMapping
    public String loginPage(){
        return "login";//page
    }
    @PostMapping("/login")
    public String login(String email, String password, Model model, HttpSession session, HttpServletRequest request){
        RestTemplate restTemplate=new RestTemplate();
        LoginDTO dto=new LoginDTO(email,password);
        String URL = "http://localhost:2022/api/users/signin";

        ResponseEntity<String> response=restTemplate.postForEntity(URL,dto,String.class);
        String token="Bearer "+response.getBody();
        request.getSession().setAttribute("token",token);
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization",token);
        HttpEntity<String> entity=new HttpEntity<String>(headers);

        return "redirect:students";
    }


    private HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
