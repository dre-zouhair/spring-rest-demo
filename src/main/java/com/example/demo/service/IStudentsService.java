package com.example.demo.service;

import com.example.demo.data.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentsService {

    List<Student> getStudents();
    Student getStudent(UUID id);
    Student addStudent(String name,String email);
    boolean updateStudent(Student student);
    boolean removeStudent(UUID id);
}
