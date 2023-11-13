package com.example.Second_homework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private UUID id;

    private String firstName;

    private String lastName;

    private Integer age;


}
