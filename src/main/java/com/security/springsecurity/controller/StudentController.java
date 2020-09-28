package com.security.springsecurity.controller;

import com.security.springsecurity.domain.Dto.StudentRequestAddDto;
import com.security.springsecurity.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student/join")
    public String saveForm(Model model){
        model.addAttribute("useraddDto", new StudentRequestAddDto());
        return "join";
    }

    @PostMapping("/student/join")
    public String save(@ModelAttribute StudentRequestAddDto requestAddDto){
        studentService.save(requestAddDto);
        return "redirect:/student/join";
    }

    @GetMapping("/student/login")
    public String loginForm(){
        return "login";
    }
}
