package com.example.librarymanagementsystem.dto.request;

import com.example.librarymanagementsystem.Enums.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {
    String title;
    int noOfPages;
    Genre genre;
    double cost;
}
