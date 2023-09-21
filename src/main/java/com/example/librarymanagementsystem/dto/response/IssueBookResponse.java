package com.example.librarymanagementsystem.dto.response;

import com.example.librarymanagementsystem.Enums.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IssueBookResponse {

    String transactionNumber;
    Date transactionTime;
    TransactionStatus transactionStatus;
    String bookName;
    String authorName;
    String studentName;
    String libraryCardNo;
}
