package com.example.thim3.controller;

import com.example.thim3.model.Book;
import com.example.thim3.service.BookService;
import com.example.thim3.service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookController", value = "/books")
public class BookController extends HttpServlet {
    private IBookService iBookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
                case "borrow":
                    //showBorrowForm(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }



        private void listBooks (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            List<Book> books = iBookService.getAllBooks();
            request.setAttribute("bookList", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        }
}
