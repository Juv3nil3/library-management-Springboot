package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Services.TransactionService;
import com.example.librarymanagementsystem.dto.response.IssueBookResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PutMapping("")
    public IssueBookResponse issueBook(@PathVariable("book-id") int bookId,
                                               @PathVariable("student-id") int studentId){
        transactionService.issueBook(bookId,studentId);
    }
}
