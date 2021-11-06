package com.example.demo.data;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class Student {
    private UUID id;
    private String name;
    private String email;

    public static boolean isNotValid(Student student){
        return student.getId() == null || !StringUtils.hasText(student.getEmail()) || !StringUtils.hasText(student.getName());
    }

    public static boolean isValid(Student student){
        return !isNotValid(student);
    }
}
