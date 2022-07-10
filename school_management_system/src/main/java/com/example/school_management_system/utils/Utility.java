package com.example.school_management_system.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utility {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
