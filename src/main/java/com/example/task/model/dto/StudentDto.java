package com.example.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String studentId;
    private String name;
    private String phoneNumber;
    private String gender;
    private String title;
    private String category;

}
