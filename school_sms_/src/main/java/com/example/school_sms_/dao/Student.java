package com.example.school_sms_.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long Id;
    private String firstname;
    private String lastname;
    private String year;
    private Integer age;
}
