package com.example.service;

import com.example.model.Course;
import java.util.List;

public interface Service {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    String deleteCourse(Long id);

    List<Course> searchByTitle(String title);
}