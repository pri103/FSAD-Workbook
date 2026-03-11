package com.klu.service;

import com.klu.entity.Student;
import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import com.klu.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Integer id) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("Student ID must be a positive number");
        }

        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }
}