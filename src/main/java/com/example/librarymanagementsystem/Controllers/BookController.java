package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Services.BookService;
import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        try{
            String response = bookService.addBook(book);
            return response;
        } catch(AuthorNotFoundException e){
            return e.getMessage();
        }
    }

    //delete a book

    //give me names of all the books of a particular genre

    //give me names of all the book of particulare genre and cost greater than 500

    //all the books having number of pages between a and b

    // names of all the author who write a particular genre


}
