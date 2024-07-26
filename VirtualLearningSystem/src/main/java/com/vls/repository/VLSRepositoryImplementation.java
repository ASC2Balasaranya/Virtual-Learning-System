package com.vls.repository;

import com.vls.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VLSRepositoryImplementation implements VLSRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/VLSDB";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load driver", e);
        }
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO Course (course_name, author_name, duration_hours, availability) VALUES ('" +
                course.getCourseName() + "', '" + course.getAuthorName() + "', " + course.getCourseDurationHours() + ", " + course.isCourseAvailability() + ")";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }



    @Override
    public Course getCourseById(int courseId) throws SQLException {
        String sql = "SELECT * FROM Course WHERE course_id = " + courseId;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return new Course(rs.getInt("course_id"), rs.getString("course_name"),
                        rs.getString("author_name"), rs.getInt("duration_hours"), rs.getBoolean("availability"));
            }
        }
        return null;
    }

    @Override
    public List<Course> getCoursesByAuthor(String authorName) throws SQLException {
        String sql = "SELECT * FROM Course WHERE author_name = '" + authorName + "'";
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(new Course(rs.getInt("course_id"), rs.getString("course_name"),
                        rs.getString("author_name"), rs.getInt("duration_hours"), rs.getBoolean("availability")));
            }
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesByName(String courseName) throws SQLException {
        String sql = "SELECT * FROM Course WHERE course_name LIKE '%" + courseName + "%'";
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(new Course(rs.getInt("course_id"), rs.getString("course_name"),
                        rs.getString("author_name"), rs.getInt("duration_hours"), rs.getBoolean("availability")));
            }
        }
        return courses;
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        String sql = "UPDATE Course SET course_name = '" + course.getCourseName() + "', author_name = '" + course.getAuthorName() +
                "', duration_hours = " + course.getCourseDurationHours() + ", availability = " + course.isCourseAvailability() + " WHERE course_id = " + course.getCourseId();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException {
        String sql = "DELETE FROM Course WHERE course_id = " + courseId;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    @Override
    public  boolean authenticateUser(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Login WHERE username = '" + username + "' AND password = '" + password + "'";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next();
        }
    }
}

