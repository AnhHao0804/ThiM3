package com.example.thim3.repository;

import com.example.thim3.connection.JDBCConnection;
import com.example.thim3.model.Book;
import com.example.thim3.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String SELECT_STUDENT = "SELECT * FROM HOC_SINH";
    JDBCConnection jdbcConnection = new JDBCConnection();

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_hoc_sinh");
                String name = rs.getString("ho_ten");
                String className = rs.getString("ten_lop");
                Student student = new Student(id,name, className);
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
