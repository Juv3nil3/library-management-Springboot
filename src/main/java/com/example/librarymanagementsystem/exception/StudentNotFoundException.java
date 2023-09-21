package com.example.librarymanagementsystem.exception;

import javax.management.relation.RelationNotFoundException;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message){
        super(message);
    }
}
