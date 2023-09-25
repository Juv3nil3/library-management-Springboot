package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.Models.Transaction;
import com.example.librarymanagementsystem.Repository.BookRepository;
import com.example.librarymanagementsystem.Repository.StudentRepository;
import com.example.librarymanagementsystem.Repository.TransactionRepository;
import com.example.librarymanagementsystem.dto.response.IssueBookResponse;
import com.example.librarymanagementsystem.exception.BookNotAvailableException;
import com.example.librarymanagementsystem.exception.StudentNotFoundException;
import com.example.librarymanagementsystem.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final TransactionRepository transactionRepository;


    public IssueBookResponse issueBook(int bookId, int studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Invalid Student Id");
        }

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new BookNotAvailableException("Invalid book Id");
        }

        Book book = bookOptional.get();
        if(book.isIssued()){
            throw new BookNotAvailableException("Book Not Available");
        }

        Student student = studentOptional.get();
        Transaction transaction = TransactionMapper.prepareTransaction(book,student);
        Transaction savedTransaction = transactionRepository.save(transaction);

        book.setIssued(true);
        book.getTransactions().add(transaction);

        student.getLibraryCard().getTransactions().add(transaction);
        Book savedBook = bookRepository.save(book);
        Student savedStudent = studentRepository.save(student);

         return TransactionMapper.prepareIssueResponse(savedTransaction);

    }
}
