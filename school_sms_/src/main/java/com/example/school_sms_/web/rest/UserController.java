package com.example.school_sms_.web.rest;
import com.example.school_sms_.dto.LoginDTO;
import com.example.school_sms_.dto.RegisterUserDto;
import com.example.school_sms_.enums.ERole;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";//page
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
    @PostMapping("/login")
    public String login(String email, String password, Model model, HttpServletRequest request){
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
    @PostMapping("register")
    public  String register(String names,String email,String password,HttpServletRequest request){
        RestTemplate restTemplate=new RestTemplate();
        RegisterUserDto dto=new RegisterUserDto(names,email,password, ERole.USER);
        System.out.println("user"+dto.getNames());
        String URL = "http://localhost:2022/api/users/register";
        restTemplate.postForEntity(URL,dto,String.class);
        return "redirect:login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}