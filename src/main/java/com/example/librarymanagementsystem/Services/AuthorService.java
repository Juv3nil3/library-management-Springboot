package com.example.librarymanagementsystem.Services;
import com.example.librarymanagementsystem.Repository.AuthorRepository;
import com.example.librarymanagementsystem.Models.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return("Author has been added successfully");
    }
}
