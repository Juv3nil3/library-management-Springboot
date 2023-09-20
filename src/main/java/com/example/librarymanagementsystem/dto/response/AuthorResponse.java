package com.example.librarymanagementsystem.dto.response;

import com.example.librarymanagementsystem.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponse {
    String name;
    int age;
    Gender gender;
    String email;
    int phone;
    List<BookResponse> listOfBooks;

}
