package com.security.springsecurity.controller;

import com.security.springsecurity.domain.Dto.StudentResponseAllDto;
import com.security.springsecurity.domain.Student;
import com.security.springsecurity.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/api/v1/student/{studentid}")
    public StudentResponseAllDto list(@PathVariable("studentid") Long student_id){
        log.info("called: " + student_id);
        StudentResponseAllDto findStudent = studentService.findByIdToDto(student_id);

        return findStudent;
    }

    @GetMapping("/api/v1/students/list")
    public List<StudentResponseAllDto> listAll(){
        return studentService.listAllToDto();
    }
}
