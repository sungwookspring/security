package com.security.springsecurity.controller;

import com.security.springsecurity.domain.Dto.StudentRequestUpdateDto;
import com.security.springsecurity.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StudentManagement_Controller {
    private final StudentService studentService;

    @PostMapping("/api/v1/student/add/{name}")
    public Long save(@PathVariable("name") String name){
        Long saveId = studentService.save(name);
        log.info("save success");

        return saveId;
    }

    @PutMapping("/api/v1/student/update")
    public Long update(@RequestBody StudentRequestUpdateDto requestUpdateDto){
        studentService.update(requestUpdateDto);
        log.info("update success");

        return requestUpdateDto.getId();
    }

    @DeleteMapping("/api/v1/student/delete/{student_id}")
    public void delete(@PathVariable("student_id") Long student_id){
        studentService.delete(student_id);

        log.info("success delete");
    }
}
