package com.example.thim3.service;

import com.example.thim3.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks ();
    List<Book> getAvailableBooks();
    Book getBookById(int id);
}
