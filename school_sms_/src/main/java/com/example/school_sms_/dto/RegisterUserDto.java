package com.example.school_sms_.dto;

import com.example.school_sms_.enums.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
        private String names;
        private String email;
        private String password;
        private ERole role;
    }

