package com.example.school_management_system.controllers;
import com.example.school_management_system.dto.LoginDTO;
import com.example.school_management_system.dto.RegisterDTO;
import com.example.school_management_system.models.User;
import com.example.school_management_system.models.enums.ERole;
import com.example.school_management_system.security.JwtTokenProvider;
import com.example.school_management_system.utils.Utility;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.school_management_system.services.IUserService;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    public UserController(IUserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @GetMapping
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
    String jwt = jwtTokenProvider.generateToken(authentication);
    return ResponseEntity.ok().body(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        User user = new ModelMapper().map(registerDTO, User.class);
        user.setPassword(Utility.encode(registerDTO.getPassword()));
        user.setRole(ERole.USER);
        return ResponseEntity.ok().body(userService.save(user));
    }
    @GetMapping("/profile")
    public ResponseEntity<?> getLoggedInUser(){
        User profile = userService.getLoggedInUser();

        return ResponseEntity.ok().body(profile);
    }
}
