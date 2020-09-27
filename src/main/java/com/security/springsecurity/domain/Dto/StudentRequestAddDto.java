package com.security.springsecurity.domain.Dto;

import com.security.springsecurity.domain.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentRequestAddDto {
    private String username;
    private String password;
    private String email;

    @Builder
    public StudentRequestAddDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
