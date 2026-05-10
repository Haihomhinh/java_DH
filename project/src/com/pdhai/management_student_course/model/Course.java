package com.pdhai.management_student_course.model;

public class Course {
    protected String courseId;
    protected String courseName;
    protected int credits;// so tin chi

    public Course(String id, String cName, int c) {
        this.courseId = id;
        this.courseName = cName;
        this.credits = c;
    }
    //-------------------------------------------
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int c) {
        credits = c;
    }
    //--------------------------------------------

    public void displayInfo() {
        System.out.println("Course ID: " + courseId + ", Name: " + courseName + ", Creadits: " + credits);
    }


}
