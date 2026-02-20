package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.model.Course;
import com.example.service.Service;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class Controller {

    @Autowired
    private Service service;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if(course.getTitle() == null || course.getFee() == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Title and Fee are required!");
        }

        Course saved = service.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Course course = service.getCourseById(id);

        if(course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found with ID: " + id);
        }

        return ResponseEntity.ok(course);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if(updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found!");
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        String message = service.deleteCourse(id);

        if(message.equals("Course Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(message);
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<?> search(@PathVariable String title) {

        List<Course> courses = service.searchByTitle(title);

        if(courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No courses found");
        }

        return ResponseEntity.ok(courses);
    }
}