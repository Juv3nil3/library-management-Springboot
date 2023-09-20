package com.example.librarymanagementsystem.dto.response;


import com.example.librarymanagementsystem.Enums.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    String title;

    int noOfPages;

    Genre genre;

    double cost;

    String authorName;
}
