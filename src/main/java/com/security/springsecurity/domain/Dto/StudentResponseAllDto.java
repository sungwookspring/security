package com.security.springsecurity.domain.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentResponseAllDto {
    private String name;

    @Builder
    public StudentResponseAllDto(String name) {
        this.name = name;
    }
}
