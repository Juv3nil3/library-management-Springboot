package com.example.librarymanagementsystem.mapper;

import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.dto.response.BookResponse;

public class BookMapper {
    public static BookResponse BookToBookResponse(Book book){
        return BookResponse.builder()
                .authorName(book.getAuthor().getName())
                .cost(book.getCost())
                .genre(book.getGenre())
                .noOfPages(book.getNoOfPages())
                .title(book.getTitle())
                .build();
    }


}
