package com.example.librarymanagementsystem.dto.response;

import com.example.librarymanagementsystem.Enums.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryCardResponse {
    String cardNo;
    CardStatus cardStatus;
    Date issueDate;

}
