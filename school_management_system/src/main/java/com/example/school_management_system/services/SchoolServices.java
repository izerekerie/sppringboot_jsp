package com.example.school_management_system.services;
import com.example.school_management_system.dto.SchoolDto;
import com.example.school_management_system.models.School;
import com.example.school_management_system.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServices {
    @Autowired
    SchoolRepository schoolRepository;

    //insertSchool
    public School insertSchool(SchoolDto sch){
        return schoolRepository.save(new School(sch));
    }
    //get all school
    public List<School> getAllSchool(){
        return schoolRepository.findAll();
    }
    //get all school in same region
    public List<School> getAllSchoolInAddress(String address){
        return  schoolRepository.findByAddress(address);
    }
    //get school by id
    public ResponseEntity<School> getSchoolById(Long id){
        Optional<School> optionalSchool= schoolRepository.findById(id);
        if(optionalSchool.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(optionalSchool.get(),HttpStatus.OK);
    }
    //update school
    public  ResponseEntity<School> updateSchoolById(Long id,SchoolDto sch){
        Optional<School> optionalSchool=schoolRepository.findById(id);
        if(optionalSchool.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            School updatedSchool=new School();
            updatedSchool.setId(id);
            updatedSchool.setName(sch.getName());
            updatedSchool.setAddress(sch.getAddress());


            return  new ResponseEntity<>(schoolRepository.save(updatedSchool),HttpStatus.OK);
        }
    }
    //delete school by id
    public ResponseEntity<School> deleteSchoolById(Long id){
        Optional<School> optionalSchool= schoolRepository.findById(id);
        if(optionalSchool.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        schoolRepository.deleteById(optionalSchool.get().getId());
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
