package com.example.librarymanagementsystem.dto.request;

import com.example.librarymanagementsystem.Enums.Gender;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRequest {
    String name;
    int age;
    Gender gender;
    String email;
    int phone;
}
