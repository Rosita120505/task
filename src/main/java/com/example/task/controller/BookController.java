package com.example.task.controller;

import com.example.task.model.dto.BookDto;
import com.example.task.model.dto.DefaultResponse;
import com.example.task.model.entity.Book;
import com.example.task.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/all")
    public List<BookDto> getListBook() {
        List<BookDto> list = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            list.add(convertEntityToDto(book));
        }
        return list;
    }

    private BookDto convertEntityToDto(Book entity) {
        BookDto dto = new BookDto();
        dto.setBookId(entity.getBookId());
        dto.setTitle(entity.getTitle());
        dto.setCategory(entity.getCategory());

        return dto;

    }

    @PostMapping("/save")
    public DefaultResponse<BookDto> saveBook(@RequestBody BookDto bookDto) {
        Book book = convertDtotoEntity(bookDto);
        DefaultResponse<BookDto> response = new DefaultResponse<>();
        Optional<Book> optionalBook = bookRepository.findByBookId(bookDto.getBookId());
        if (optionalBook.isPresent()) {
            response.setStatus(Boolean.FALSE);
            response.setMessage(("Gagal Menyimpan, Buku Telah Tersedia"));
        } else {
            bookRepository.save(book);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Buku Berhasil Disimpan");
            response.setData(bookDto);
        }
        return response;
    }

    private Book convertDtotoEntity(BookDto bookDto) {
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setTitle(bookDto.getTitle());
        book.setCategory(bookDto.getCategory());

        return book;
    }

    @PutMapping("/update/{bookId}")
    public DefaultResponse updateById(@PathVariable String bookId, @RequestBody BookDto bookDto) {
        DefaultResponse defaultResponse = new DefaultResponse();
        try {
            Optional<Book> optionalBook = bookRepository.findByBookId(bookId);
            Book book = optionalBook.get();
            if (optionalBook.isPresent()) {
                book.setTitle(bookDto.getTitle());
                book.setCategory(bookDto.getCategory());
                bookRepository.save(book);
                defaultResponse.setStatus(Boolean.TRUE);
                defaultResponse.setData(bookDto);
                defaultResponse.setMessage("Succeeded update data");
            }
        } catch (Exception e) {
            defaultResponse.setStatus(Boolean.FALSE);
            defaultResponse.setMessage("Failed to update data, Id was not found");
        }
        return defaultResponse;
    }

    @DeleteMapping("/delete/{bookId}")
    public DefaultResponse deleteByBookId(@PathVariable String bookId) {
        DefaultResponse df = new DefaultResponse();
        Optional<Book> optionalBook = bookRepository.findByBookId(bookId);
        if (optionalBook.isPresent()) {
            bookRepository.delete(optionalBook.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }
}
