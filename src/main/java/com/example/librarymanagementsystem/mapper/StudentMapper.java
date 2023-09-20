package com.example.librarymanagementsystem.mapper;

import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.dto.request.StudentRequest;
import com.example.librarymanagementsystem.dto.response.StudentResponse;

public class StudentMapper {
    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static StudentResponse StudentToStudentResponse(Student student){
        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardResponse(LibraryCardMapper.cardResponse(student))
                .build();
    }
}
