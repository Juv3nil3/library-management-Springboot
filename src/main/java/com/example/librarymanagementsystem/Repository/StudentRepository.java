package com.example.librarymanagementsystem.Repository;

import com.example.librarymanagementsystem.Enums.Gender;
import com.example.librarymanagementsystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByGender(Gender gender);
    Student findByEmail(String email);
}
