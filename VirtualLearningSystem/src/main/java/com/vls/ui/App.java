package com.vls.ui;

import com.vls.model.Course;
import com.vls.service.VLSService;
import com.vls.service.VLSServiceImplementation;
import com.vls.service.LoginService;
import com.vls.service.LoginServiceImplementation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    private LoginService loginService = new LoginServiceImplementation();
    private VLSService courseService = new VLSServiceImplementation();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        // Login Process
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            if (loginService.authenticateUser(username, password)) {
                System.out.println("Login successful!");

                boolean exit = false;
                while (!exit) {
                    System.out.println("Choose an operation: (1) Create Course, (2) Read Course, (3) Update Course, (4) Delete Course, (5) Search Course, (6) Quit");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (choice) {
                        case 1:
                            createCourse(scanner);
                            break;
                        case 2:
                            readCourse(scanner);
                            break;
                        case 3:
                            updateCourse(scanner);
                            break;
                        case 4:
                            deleteCourse(scanner);
                            break;
                        case 5:
                            searchCourse(scanner);
                            break;
                        case 6:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private void createCourse(Scanner scanner) throws SQLException {
        System.out.println("Enter course name:");
        String courseName = scanner.nextLine();
        System.out.println("Enter author name:");
        String authorName = scanner.nextLine();
        System.out.println("Enter duration in hours:");
        int durationHours = scanner.nextInt();
        System.out.println("Enter availability (true/false):");
        boolean availability = scanner.nextBoolean();

        Course course = new Course(0, courseName, authorName, durationHours, availability);
        courseService.addCourse(course);
        System.out.println("Course added successfully!");
    }

    private void readCourse(Scanner scanner) throws SQLException {
        System.out.println("Enter course ID:");
        int courseId = scanner.nextInt();
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private void updateCourse(Scanner scanner) throws SQLException {
        System.out.println("Enter course ID to update:");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            System.out.println("Enter new course name:");
            String courseName = scanner.nextLine();
            System.out.println("Enter new author name:");
            String authorName = scanner.nextLine();
            System.out.println("Enter new duration in hours:");
            int durationHours = scanner.nextInt();
            System.out.println("Enter new availability (true/false):");
            boolean availability = scanner.nextBoolean();

            course.setCourseName(courseName);
            course.setAuthorName(authorName);
            course.setCourseDurationHours(durationHours);
            course.setCourseAvailability(availability);

            courseService.updateCourse(course);
            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Course not found.");
        }
    }

    private void deleteCourse(Scanner scanner) throws SQLException {
        System.out.println("Enter course ID to delete:");
        int courseId = scanner.nextInt();
        courseService.deleteCourse(courseId);
        System.out.println("Course deleted successfully!");
    }

    private void searchCourse(Scanner scanner) throws SQLException {
        System.out.println("Search by (1) Author Name, (2) Course Name:");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Course> courses = null;
        switch (choice) {
            case 1:
                System.out.println("Enter author name:");
                String authorName = scanner.nextLine();
                courses = courseService.getCoursesByAuthor(authorName);
                break;
            case 2:
                System.out.println("Enter course name:");
                String courseName = scanner.nextLine();
                courses = courseService.getCoursesByName(courseName);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found.");
        }
    }
}
