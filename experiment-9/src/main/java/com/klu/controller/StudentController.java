package com.klu.controller;
import com.klu.entity.Student;
import com.klu.exception.InvalidInputException;
import com.klu.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        try {
            Integer studentId = Integer.parseInt(id);
            return studentService.getStudentById(studentId);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input: Student ID must be a number");
        }
    }
}