package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Services.TransactionService;
import com.example.librarymanagementsystem.dto.response.IssueBookResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/issue/{book-id}/{student-id}")
    public ResponseEntity issueBook(@PathVariable("book-id") int bookId,
                                    @PathVariable("student-id") int studentId){
        try{
            IssueBookResponse response = transactionService.issueBook(bookId,studentId);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
