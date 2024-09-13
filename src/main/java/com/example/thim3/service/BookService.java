package com.example.thim3.service;

import com.example.thim3.model.Book;
import com.example.thim3.repository.BookRepository;
import com.example.thim3.repository.IBookRepository;

import java.util.Collections;
import java.util.List;

public class BookService implements IBookService{
    IBookRepository iBookRepository = new BookRepository();
    @Override
    public List<Book> getAllBooks() {
        return iBookRepository.getAllBooks();
    }

    @Override
    public List<Book> getAvailableBooks() {
        return iBookRepository.getAvailableBooks();
    }

    @Override
    public Book getBookById(int id) {
        return iBookRepository.getBookById(id);
    }
}
