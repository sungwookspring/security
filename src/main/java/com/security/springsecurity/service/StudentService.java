package com.security.springsecurity.service;

import com.security.springsecurity.domain.Student;
import com.security.springsecurity.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public Long save(Student student){
        return studentRepository.save(student).getId();
    }
}
