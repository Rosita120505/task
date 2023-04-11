package com.example.task.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
}
