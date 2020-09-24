package com.security.springsecurity.repository;

import com.security.springsecurity.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
