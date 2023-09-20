package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Services.AuthorService;
import com.example.librarymanagementsystem.dto.request.AuthorRequest;
import com.example.librarymanagementsystem.dto.response.AuthorResponse;
import com.example.librarymanagementsystem.dto.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AuthorRequest authorRequest){
        String response = authorService.addAuthor(authorRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    //update the email if of an author  -->> observer lastActivity column

    @PutMapping("/update-email/{id}")
    public ResponseEntity updateEmail(@PathVariable("id") int id, @RequestParam("email") String email){
        String response = authorService.updateEmail(id, email);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    //give me names of all the books written by a particular author

    @GetMapping("/get-books/{id}")
    public List<BookResponse> getBooksByAuthor(@PathVariable("id") int id){
        return authorService.getBooksByAuthor(id);
    }

    //give the names of authors who have written more than 'x' number of books
    @GetMapping("/getByNo/{n}")
    public List<String> getByNumbers(@PathVariable("n") int n){
        return authorService.getByNumbers(n);
    }

}
