package org.etjen.spring_sec.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.etjen.spring_sec.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Navin", "Java"),
            new Student(2, "Kiran", "Blockchain")
    ));

    @GetMapping("csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @GetMapping("students")
    public List<Student> getStudentList(){
        return studentList;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student){
        studentList.add(student);
    }
}
