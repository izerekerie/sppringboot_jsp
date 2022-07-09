package com.example.school_management_system.dto;


public class SchoolDto {
    private String name;
    private String address;

    public SchoolDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SchoolDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
