package com.security.springsecurity.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "student")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String name;

    @Builder
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /***
     * 이름 변경
     * @param name
     */
    public void update(String name) {
        this.name = name;
    }
}
