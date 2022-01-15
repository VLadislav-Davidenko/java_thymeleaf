package com.example.java_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private UserStatus status;

    public int bornAt(){
        return LocalDate.now().minusYears(age).getYear();
    }
}
