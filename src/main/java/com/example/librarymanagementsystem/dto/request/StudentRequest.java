package com.example.librarymanagementsystem.dto.request;

import com.example.librarymanagementsystem.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String name;
    int age;
    String email;
    Gender gender;
}
