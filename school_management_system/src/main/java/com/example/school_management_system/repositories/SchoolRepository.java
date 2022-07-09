package com.example.school_management_system.repositories;

import com.example.school_management_system.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SchoolRepository  extends JpaRepository<School,Long> {
//    List<School> findSchoolByAddress(String address);
    List<School> findByAddress(String address);
}
