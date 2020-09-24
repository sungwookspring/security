package com.security.springsecurity.controller;

import com.security.springsecurity.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/api/v1/students/{studentid}")
    public Student list(@PathVariable("studentid") Long studentid){
        return Student.builder().build();
    }

}
