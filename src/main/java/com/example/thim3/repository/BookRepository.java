package com.example.thim3.repository;

import com.example.thim3.connection.JDBCConnection;
import com.example.thim3.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRepository implements IBookRepository {
    private static final String SELECT_BOOK = "SELECT * FROM SACH";
    private static final String SELECT_AVAILABLE_BOOKS = "SELECT * FROM SACH WHERE so_luong > 0";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM SACH WHERE ma_sach = ?";
    JDBCConnection jdbcConnection = new JDBCConnection();

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_sach");
                String name = rs.getString("ten_sach");
                String author = rs.getString("tac_gia");
                String description = rs.getString("mo_ta");
                int quantity = rs.getInt("so_luong");
                Book book = new Book(id,name, author, description, quantity);
                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public List<Book> getAvailableBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AVAILABLE_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_sach");
                String name = rs.getString("ten_sach");
                String author = rs.getString("tac_gia");
                String description = rs.getString("mo_ta");
                int quantity = rs.getInt("so_luong");
                Book book = new Book(id, name, author, description, quantity);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book getBookById(int id) {
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("ten_sach");
                String author = rs.getString("tac_gia");
                String description = rs.getString("mo_ta");
                int quantity = rs.getInt("so_luong");
                return new Book(id, name, author, description, quantity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



}
