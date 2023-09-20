package com.example.librarymanagementsystem.mapper;

import com.example.librarymanagementsystem.Enums.CardStatus;
import com.example.librarymanagementsystem.Models.LibraryCard;
import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.dto.request.StudentRequest;
import com.example.librarymanagementsystem.dto.response.LibraryCardResponse;

import java.util.UUID;

public class LibraryCardMapper {
    public static LibraryCard prepareLibraryCard(){
        return LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }

    public static LibraryCardResponse cardResponse(Student student){
        return LibraryCardResponse.builder()
                .cardNo(student.getLibraryCard().getCardNo())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .issueDate(student.getLibraryCard().getIssueDate())
                .build();
    }
}
