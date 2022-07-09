package com.example.school_management_system.repositories;

import com.example.school_management_system.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {

}
