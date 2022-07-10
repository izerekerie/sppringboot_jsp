package com.example.school_management_system.dto;

import com.example.school_management_system.models.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String names;
    private String email;
    private String password;
    private ERole role;
}
