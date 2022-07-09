package com.example.school_management_system.controllers;


import com.example.school_management_system.dto.SchoolDto;
import com.example.school_management_system.models.School;
import com.example.school_management_system.services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/schools")
public class SchoolController {


    @Autowired
    SchoolServices schoolServices;


    //getAll schools
    @GetMapping
    public List<School> getAllSchools(){
        return schoolServices.getAllSchool();
    }

    //add school
    @PostMapping
    public School addSchool(@RequestBody SchoolDto dto){

        return  schoolServices.insertSchool(dto);
    }
    //getschool by id
    @GetMapping("/{id}")
    public HttpEntity<School> findById(@PathVariable Long id){
        return schoolServices.getSchoolById(id);
    }
    //updated school
    @PutMapping("/{id}")
    public  HttpEntity<School> updateSchool(@PathVariable Long id,@RequestBody SchoolDto newSch){

        return schoolServices.updateSchoolById(id,newSch);
    }
    //delete school by id
    @DeleteMapping("/{id}")
    public HttpEntity<School> deleteSchoolbyId(@PathVariable Long id){

        return schoolServices.deleteSchoolById(id);
    }

}
