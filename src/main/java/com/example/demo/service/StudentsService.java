package com.example.demo.service;

import com.example.demo.data.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentsService implements IStudentsService {
    @Override
    public List<Student> getStudents() {
        return StudentRepository.students;
    }

    @Override
    public Student getStudent(UUID id) {
        for(Student student : StudentRepository.students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student addStudent(String name, String email) {
        Student student = new Student().setId(UUID.randomUUID()).setName(name).setEmail(email);
        StudentRepository.students.add(student);
        return student;
    }

    @Override
    public boolean updateStudent(Student student) {
        for(Student target : StudentRepository.students){
            if(target.getId().equals(student.getId())){
                target.setEmail(student.getEmail()).setName(student.getName());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeStudent(UUID id) {
       return StudentRepository.students.removeIf(student -> student.getId().equals(id));
    }


}
