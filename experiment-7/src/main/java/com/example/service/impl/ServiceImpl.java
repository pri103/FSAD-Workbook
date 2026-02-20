package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repo.Repo;
import com.example.model.Course;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements com.example.service.Service {

    @Autowired
    private Repo repo;

    @Override
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = repo.findById(id);
        return course.orElse(null);
    }

    @Override
    public Course updateCourse(Long id, Course newCourse) {
        Optional<Course> optional = repo.findById(id);

        if(optional.isPresent()) {
            Course course = optional.get();
            course.setTitle(newCourse.getTitle());
            course.setDuration(newCourse.getDuration());
            course.setFee(newCourse.getFee());
            return repo.save(course);
        }
        return null;
    }

    @Override
    public String deleteCourse(Long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "Course Deleted Successfully";
        }
        return "Course Not Found";
    }

    @Override
    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}