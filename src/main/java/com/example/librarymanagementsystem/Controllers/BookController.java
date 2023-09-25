package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Services.BookService;
import com.example.librarymanagementsystem.dto.request.BookRequest;
import com.example.librarymanagementsystem.dto.response.BookResponse;
import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/add")
    public String addBook(@RequestBody BookRequest bookRequest){
        try{
            String response = bookService.addBook(bookRequest);
            return response;
        } catch(AuthorNotFoundException e){
            return e.getMessage();
        }
    }

    //delete a book
    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@RequestParam("id") int authorId, @RequestParam("name") String title){
        try{
            String response = bookService.deleteBook(authorId,title);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (AuthorNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //give me all the books of a particular genre
    @GetMapping("/get-books-by-genre")
    public List<BookResponse> getBooksByGenre(@RequestParam("genre") Genre genre){
        List<BookResponse> response = bookService.getBooksByGenre(genre);
        return response;
    }



    //give me all the book of particular genre and cost greater than x
    @GetMapping("/get-by-genre-cost")
    public List<BookResponse> getBooksByGenreAndGreater (@RequestParam("genre") Genre genre,@RequestParam("cost") double cost){
        List<BookResponse> response = bookService.getBooksByGenreAndGreater(genre,cost);
        return response;
    }

    //all the books having number of pages between a and b
    @GetMapping("/get-by-pages")
    public ResponseEntity getBooksByPages(@RequestParam("a") int a, @RequestParam("b") int b){
        List<BookResponse> response = bookService.getBooksByPages(a,b);
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    // names of all the author who write a particular genre
    @GetMapping("get-author-by-genre")
    public ResponseEntity getAuthorsByGenre (Genre genre){
        List<String> response = bookService.getAuthorsByGenre(genre);
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

}
