package com.example.school_management_system.models;

import com.example.school_management_system.dto.SchoolDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    public School(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public School() {

    }



    public School(SchoolDto dto){
        this.name = dto.getName();
        this.address = dto.getAddress();
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
