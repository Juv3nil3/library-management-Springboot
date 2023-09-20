package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Enums.CardStatus;
import com.example.librarymanagementsystem.Enums.Gender;
import com.example.librarymanagementsystem.Models.LibraryCard;
import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.Repository.StudentRepository;
import com.example.librarymanagementsystem.dto.request.StudentRequest;
import com.example.librarymanagementsystem.dto.response.StudentResponse;
import com.example.librarymanagementsystem.mapper.LibraryCardMapper;
import com.example.librarymanagementsystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student = StudentMapper.StudentRequestToStudent(studentRequest);
        LibraryCard libraryCard = LibraryCardMapper.prepareLibraryCard();
        libraryCard.setStudent(student);
        student.setLibraryCard(libraryCard);

        Student savedStudent = studentRepository.save(student);
        return StudentMapper.StudentToStudentResponse(savedStudent);
    }

    public StudentResponse getStudent(int regNo) {
        Optional<Student>studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return (StudentMapper.StudentToStudentResponse(studentOptional.get()));
        }
        return null;
    }

    public List<StudentResponse> getAllMales() {

        List<StudentResponse> response = new ArrayList<>();
        List<Student> students = studentRepository.findByGender(Gender.MALE);
        for(Student s: students){
            response.add(StudentMapper.StudentToStudentResponse(s));
        }
        return response;
    }

    public String deleteStudent(int regNo) {
        studentRepository.deleteById(regNo);
        return "Student deleted successfully";
    }

    public String updateAge(int regNo, int age) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        Student student = studentOptional.get();
        student.setAge(age);
        studentRepository.save(student);
        return "Age changed successfully";
    }

    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> allStudents = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for(Student s: students){
            allStudents.add(StudentMapper.StudentToStudentResponse(s));
        }
        return allStudents;
    }
}
