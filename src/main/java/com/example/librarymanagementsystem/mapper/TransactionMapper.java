package com.example.librarymanagementsystem.mapper;

import com.example.librarymanagementsystem.Enums.TransactionStatus;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.Models.Transaction;
import com.example.librarymanagementsystem.dto.response.IssueBookResponse;

import java.util.UUID;

public class TransactionMapper {
    public static Transaction prepareTransaction(Book book, Student student){
        return Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();
    }

    public static IssueBookResponse prepareIssueResponse(Transaction transaction){
        return IssueBookResponse.builder()
                .transactionNumber(transaction.getTransactionNumber())
                .transactionTime(transaction.getTransactionTime())
                .transactionStatus(transaction.getTransactionStatus())
                .bookName(transaction.getBook().getTitle())
                .authorName(transaction.getBook().getAuthor().getName())
                .studentName(transaction.getLibraryCard().getStudent().getName())
                .libraryCardNo(transaction.getLibraryCard().getCardNo())
                .build();
    }
}
