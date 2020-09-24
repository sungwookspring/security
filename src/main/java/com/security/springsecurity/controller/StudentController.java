package com.security.springsecurity.controller;

import com.security.springsecurity.domain.Dto.StudentResponseAllDto;
import com.security.springsecurity.domain.Student;
import com.security.springsecurity.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

//    @GetMapping("/api/v1/students/{studentid}")
//    public Student list(@PathVariable("studentid") Long studentid){
//
//        return Student.builder().build();
//    }

    @GetMapping("/api/v1/students/list")
    public List<StudentResponseAllDto> listAll(){
        return studentService.listAllToDto();
    }
}
