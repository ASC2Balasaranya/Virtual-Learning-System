package com.vls.service;

import com.vls.model.Course;

import com.vls.repository.VLSRepository;
import com.vls.repository.VLSRepositoryImplementation;

import java.sql.SQLException;
import java.util.List;

public  class VLSServiceImplementation implements VLSService {
    private VLSRepository courseRepository = new VLSRepositoryImplementation();

    @Override
    public void addCourse(Course course) throws SQLException {
        courseRepository.addCourse(course);
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public List<Course> getCoursesByAuthor(String authorName) throws SQLException {
        return courseRepository.getCoursesByAuthor(authorName);
    }

    @Override
    public List<Course> getCoursesByName(String courseName) throws SQLException {
        return courseRepository.getCoursesByName(courseName);
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        courseRepository.updateCourse(course);
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException {
        courseRepository.deleteCourse(courseId);
    }


}

