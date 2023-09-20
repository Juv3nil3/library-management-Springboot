package com.example.librarymanagementsystem.Repository;

import com.example.librarymanagementsystem.Enums.Genre;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.dto.response.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByGenre(Genre genre);
    @Query(value = "select b from Book b where b.genre = :genre and b.cost >= :cost")
    List<Book> getBooksByGenreAndGreater(Genre genre, double cost);

    @Query(value = "select b from Book b where b.noOfPages >= :a and b.noOfPages <= :b")
    List<Book> getBooksByPages(int a, int b);
}
