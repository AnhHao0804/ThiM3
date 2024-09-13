package com.example.thim3.service;

import com.example.thim3.model.Student;
import com.example.thim3.repository.IStudentRepository;
import com.example.thim3.repository.StudentRepository;

import java.util.Collections;
import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> getAllStudents() {
        return iStudentRepository.getAllStudents();
    }
}
