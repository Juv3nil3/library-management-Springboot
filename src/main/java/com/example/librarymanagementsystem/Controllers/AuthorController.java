package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String response = authorService.addAuthor(author);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    //update the email if of an author  -->> observer lastActivity column

    //give me the names of all the books written by a particular author

    //give the names of authors who have written more than 'x' number of books

}
