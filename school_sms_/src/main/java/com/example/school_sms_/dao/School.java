package com.example.school_sms_.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private Long id;
    private String name;
    private String address;
}
