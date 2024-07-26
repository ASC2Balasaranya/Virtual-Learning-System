package com.vls.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VLSTest {

    @Test
    void testDefaultConstructor() {
        Course course = new Course(1,"java","saranya",5,true);
        assertNotNull(course);
    }

    @Test
    void testParameterizedConstructor() {
        Course course = new Course(1, "Java Basics", "John Doe", 5, true);
        assertEquals(1, course.getCourseId());
        assertEquals("Java Basics", course.getCourseName());
        assertEquals("John Doe", course.getAuthorName());
        assertEquals(5, course.getCourseDurationHours());

    }

    @Test
    void testSettersAndGetters() {
        Course course = new Course(1,"Java ","Saranya",5,true);
        course.setCourseId(1);
        course.setCourseName("Java ");
        course.setAuthorName("Saranya");
        course.setCourseAvailability(true);

        assertEquals(1, course.getCourseId());
        assertEquals("Java ", course.getCourseName());
        assertEquals("Saranya", course.getAuthorName());
        assertEquals(5, course.getCourseDurationHours());
        assertTrue(course.isCourseAvailability());
    }

    @Test
    void testToString() {
        Course course = new Course(1, "Java", "saranya", 5, true);
        String expected="Course Details: COURSE_ID="+"1"+"\t"+
                "COURSE_NAME="+"Java"+"\t"+
                "COURSE_AUTHOR="+"saranya"+"\t"+
                "COURSE_DURATION="+5 +"\t"+
                "COURSE_AVAILABILITY="+"true";
        assertEquals(expected, course.toString());
    }
}
