package com.example.demo.controller;

import com.example.demo.data.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.service.IStudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    private IStudentsService studentsService;

    public StudentController(IStudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/api/v1/students")
    public List<Student> getStudents(){
        return studentsService.getStudents();
    }



    @GetMapping("/api/v1/student/{id}")
    public Student getStudent(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return studentsService.getStudent(uuid);
    }

    @PostMapping("/api/v1/student")
    public Student addStudent(@RequestBody Student student){
        if(Student.isValid(student)){
            return studentsService.addStudent(student.getName(),student.getEmail());
        }else{
            throw new StudentNotFoundException("invalid data in "+student.getName()+" "+ student.getEmail());

        }
    }

    @PutMapping("/api/v1/student")
    public void updateStudent(@RequestBody Student student){
        if(Student.isNotValid(student) || !studentsService.updateStudent(student)){
            throw new StudentNotFoundException("invalid data in "+student.getName()+" "+ student.getEmail());
        }
    }

    @DeleteMapping("/api/v1/student")
    public void removeStudent(@RequestBody Student student){
        if(!studentsService.removeStudent(student.getId())){
            throw new StudentNotFoundException("unable to find student with this id : "+student.getId());
        }
    }

}
