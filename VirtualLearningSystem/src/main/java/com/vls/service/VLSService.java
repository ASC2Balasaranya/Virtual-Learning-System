package com.vls.service;

import com.vls.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface VLSService {
    void addCourse(Course course) throws SQLException;

     Course getCourseById(int courseId) throws SQLException;

     List<Course> getCoursesByAuthor(String authorName) throws SQLException;

     List<Course> getCoursesByName(String courseName) throws SQLException;

     void updateCourse(Course course) throws SQLException;

     void deleteCourse(int courseId) throws SQLException;


}
