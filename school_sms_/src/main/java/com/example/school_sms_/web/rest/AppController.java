package com.example.school_sms_.web.rest;

import com.example.school_sms_.dao.School;
import com.example.school_sms_.dao.User;
import com.example.school_sms_.dto.LoginDTO;
import com.example.school_sms_.dto.RegisterUserDto;
import com.example.school_sms_.dto.SchoolDto;
import com.example.school_sms_.enums.ERole;
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

}
