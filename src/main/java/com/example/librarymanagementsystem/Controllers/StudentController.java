package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo) {
        Student student = studentService.getStudent(regNo);
        if(student!= null){
            return new ResponseEntity<>(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid Id",HttpStatus.BAD_REQUEST);
    }

    //delete a student --> regNo

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam int regNo){
        String response = studentService.deleteStudent(regNo);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    //update the age of student  --> regNo age

    //get all the students in the db

    //get all the male students
    @GetMapping("/get-males")
    public List<String> getAllMales(){
        return studentService.getAllMales();
    }
}
