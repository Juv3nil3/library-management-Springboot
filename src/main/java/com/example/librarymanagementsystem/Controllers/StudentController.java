package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.Services.StudentService;
import com.example.librarymanagementsystem.dto.request.StudentRequest;
import com.example.librarymanagementsystem.dto.response.StudentResponse;
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
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse response = studentService.addStudent(studentRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo) {
        StudentResponse response = studentService.getStudent(regNo);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid Id",HttpStatus.BAD_REQUEST);
    }

    //delete a student --> regNo

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int regNo){
        String response = studentService.deleteStudent(regNo);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    //update the age of student  --> regNo age

    @PutMapping("/update-age/{regNo}")
    public ResponseEntity updateAge(@PathVariable int regNo, @RequestParam("age") int age){
        String response = studentService.updateAge(regNo, age);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    //get all the students in the db
    @GetMapping("/get-all")
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    //get all the male students
    @GetMapping("/get-males")
    public List<StudentResponse> getAllMales(){
        return studentService.getAllMales();
    }
}
