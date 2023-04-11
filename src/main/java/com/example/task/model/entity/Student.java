package com.example.task.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "phone_number")
    private String phoneNumber;
}
