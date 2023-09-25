package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Repository.AuthorRepository;
import com.example.librarymanagementsystem.Repository.BookRepository;
import com.example.librarymanagementsystem.dto.request.BookRequest;
import com.example.librarymanagementsystem.dto.response.BookResponse;
import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public String addBook(BookRequest bookRequest) {
        Optional<Author> authorOptional = authorRepository.findById(bookRequest.getAuthorId());
        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid author id!!!");
        }

        Author author = authorOptional.get();
        Book book = BookMapper.BookRequestToBook(bookRequest);
        book.setAuthor(author);

        author.getBooks().add(book);

        authorRepository.save(author);  //This will save both author and book
        return("Book saved successfully");
    }


    public List<BookResponse> getBooksByGenreAndGreater( Genre genre, double cost) {
        List<Book> books = bookRepository.getBooksByGenreAndGreater(genre,cost);

        //Convert the model to dto
        List<BookResponse> responses = new ArrayList<>();
        for(Book book : books){
            responses.add(BookMapper.BookToBookResponse(book));
        }
        return responses;

    }

    public String deleteBook(int authorId, String title) {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        Author author = authorOptional.get();
        List<Book> books = author.getBooks();
        Book toDeleteBook = null;
        for(Book b : books){
            if(b.getTitle().equals(title)){
                toDeleteBook = b;
                break;
            }
        }
        books.remove(toDeleteBook);
        return "Book deleted successfully";
    }

    public List<BookResponse> getBooksByGenre(Genre genre) {
        List<Book> books = bookRepository.findByGenre(genre);

        List<BookResponse> response = new ArrayList<>();
        for(Book b : books){
            response.add(BookMapper.BookToBookResponse(b));
        }
        return response;
    }

    public List<BookResponse> getBooksByPages(int a, int b) {
        List<Book> books = bookRepository.getBooksByPages(a,b);
        List<BookResponse> response = new ArrayList<>();
        for(Book book : books){
            response.add(BookMapper.BookToBookResponse(book));
        }
        return response;
    }

    public List<String> getAuthorsByGenre(Genre genre) {
        List<Book> books = bookRepository.findByGenre(genre);
        List<String> names = new ArrayList<>();
        for(Book b : books){
            names.add(b.getAuthor().getName());
        }
        return names;
    }
}
