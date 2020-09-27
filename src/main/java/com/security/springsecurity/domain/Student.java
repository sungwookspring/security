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

    private String username;

    private String email;

    private String password;

    private String role;

    @Builder
    public Student(Long id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /***
     * 이름 변경
     * @param username
     */
    public void update(String username) {
        this.username = username;
    }
}
