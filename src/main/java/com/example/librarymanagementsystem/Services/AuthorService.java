package com.example.librarymanagementsystem.Services;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Repository.AuthorRepository;
import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.dto.request.AuthorRequest;
import com.example.librarymanagementsystem.dto.response.BookResponse;
import com.example.librarymanagementsystem.mapper.AuthorMapper;
import com.example.librarymanagementsystem.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    public String addAuthor(AuthorRequest authorRequest) {
        Author author = AuthorMapper.AuthorRequestToAuthor(authorRequest);
        authorRepository.save(author);
        return("Author has been added successfully");
    }

    public String updateEmail(int id, String email) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        Author author  = authorOptional.get();
        author.setEmail(email);
        authorRepository.save(author);
        return "Email changed successfully";
    }

    public List<BookResponse> getBooksByAuthor(int id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        Author author = authorOptional.get();

        List<BookResponse> response = new ArrayList<>();
        List<Book> books = author.getBooks();
        for(Book b: books){
            response.add(BookMapper.BookToBookResponse(b));
        }
        return response;
    }

    public List<String> getByNumbers(int n) {
        List<Author> authors = authorRepository.findAll();
        List<String> names = new ArrayList<>();
        for(Author a : authors){
            if(a.getBooks().size() >= n){
                names.add(a.getName());
            }
        }
        return names;
    }
}
