package com.example.librarymanagementsystem.mapper;

import com.example.librarymanagementsystem.Models.Author;
import com.example.librarymanagementsystem.dto.request.AuthorRequest;

public class AuthorMapper {
    public static Author AuthorRequestToAuthor(AuthorRequest authorRequest){
        return Author.builder()
                .name(authorRequest.getName())
                .age(authorRequest.getAge())
                .email(authorRequest.getEmail())
                .gender(authorRequest.getGender())
                .phone(authorRequest.getPhone())
                .build();
    }
}
