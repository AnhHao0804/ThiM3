package com.example.thim3.repository;

import com.example.thim3.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> getAllBooks ();
    List<Book> getAvailableBooks();
    Book getBookById(int id);
}
