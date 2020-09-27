package com.security.springsecurity.controller;

import com.security.springsecurity.domain.Dto.StudentRequestUpdateDto;
import com.security.springsecurity.domain.Dto.StudentResponseAllDto;
import com.security.springsecurity.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/api/v1/students")
@Slf4j
public class StudentManagement_Controller {
    private final StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINE', 'ROLE_MANAGER')")
    public List<StudentResponseAllDto> listAll(){
        return studentService.listAllToDto();
    }

    @PostMapping(path = "{name}")
    @PreAuthorize("hasAuthority('student:write')")
    public Long save(@PathVariable("name") String name){
        Long saveId = studentService.save(name);
        log.info("save success");

        return saveId;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('student:write')")
    public Long update(@RequestBody StudentRequestUpdateDto requestUpdateDto){
        studentService.update(requestUpdateDto);
        log.info("update success");

        return requestUpdateDto.getId();
    }

    @DeleteMapping(path = "{student_id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void delete(@PathVariable("student_id") Long student_id){
        studentService.delete(student_id);

        log.info("success delete");
    }
}
