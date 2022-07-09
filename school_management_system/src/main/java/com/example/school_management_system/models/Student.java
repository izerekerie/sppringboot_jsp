package com.example.school_management_system.models;

import com.example.school_management_system.dto.StudentDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String firstname;
    private String lastname;
    private Integer age;
    private String year;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



    public Student() {
    }
    public Student(StudentDto st){
        this.firstname=st.getFirstname();
        this.lastname=st.getLastname();
        this.age=st.getAge();
        this.year=st.getYear();
    }

}
