package com.vls.model;

public class Course {
    private int courseId;
    private String courseName;
    private String authorName;
    private int courseDurationHours;
    private boolean courseAvailability;

    public Course(int courseId, String courseName, String aurthorName, int courseDuration, boolean courseAvailabiliy){
        this.courseId=courseId;
        this.courseName=courseName;
        this.authorName=aurthorName;
        this.courseDurationHours =courseDuration;
        this.courseAvailability=courseAvailabiliy;
    }

    public int getCourseId(){
        return this.courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthorName() {
        return this.authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCourseDurationHours() {
        return this.courseDurationHours;
    }
    public void setCourseDurationHours(int courseDurationHours) {
        this.courseDurationHours = courseDurationHours;
    }

    public boolean isCourseAvailability() {
        return this.courseAvailability;
    }
    public void setCourseAvailability(boolean courseAvailability) {
        this.courseAvailability = courseAvailability;
    }

    @Override
    public String toString(){
        return "Course Details: COURSE_ID="+courseId+"\t"+
                "COURSE_NAME="+courseName+"\t"+
                "COURSE_AUTHOR="+authorName+"\t"+
                "COURSE_DURATION="+ courseDurationHours +"\t"+
                "COURSE_AVAILABILITY="+courseAvailability;
    }
}
