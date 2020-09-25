package com.security.springsecurity.service;

import com.security.springsecurity.domain.Dto.StudentRequestUpdateDto;
import com.security.springsecurity.domain.Dto.StudentResponseAllDto;
import com.security.springsecurity.domain.Student;
import com.security.springsecurity.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public Long save(Student student){
        return studentRepository.save(student).getId();
    }

    @Transactional
    public Long save(String name){
        Student new_stuent = Student.builder()
                .name(name)
                .build();
        return studentRepository.save(new_stuent).getId();
    }

    /***
     * 모든 학생 리스트 리턴
     * @return List<StudentResponseAllDto>
     */
    public List<StudentResponseAllDto> listAllToDto(){
        List<Student> students = studentRepository.findAll();

        List<StudentResponseAllDto> dtos = students.stream()
                .map(student -> StudentResponseAllDto.builder()
                        .name(student.getName())
                        .build())
                .collect(Collectors.toList());

        return dtos;
    }

    public StudentResponseAllDto findByIdToDto(Long student_id){
        Student findStudent = studentRepository.findById(student_id)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 student_id")
                );

        return StudentResponseAllDto.builder()
                .name(findStudent.getName())
                .build();
    }

    @Transactional
    public void delete(Long student_id){
        Student findStudent = studentRepository.findById(student_id)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 student_id")
                );

        studentRepository.delete(findStudent);
    }

    @Transactional
    public void update(StudentRequestUpdateDto requestUpdateDto) {
        Student findStudent = studentRepository.findById(requestUpdateDto.getId())
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 student_id")
                );

        findStudent.update(requestUpdateDto.getName());
    }
}
