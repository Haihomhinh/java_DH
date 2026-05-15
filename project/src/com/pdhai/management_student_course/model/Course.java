package com.pdhai.management_student_course.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Course implements Printable{
    protected String courseId;
    protected String courseName;
    protected int credits;// so tin chi

    protected Set<Student> students = new HashSet<>();
    
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

    @Override
    public void printDetails() {
        displayInfo();
    }

    public void addStudent(Student s) {
        if (s != null) {
            students.add(s);
        }
    }

    public void removeStudent(String id) {
        students.removeIf(s -> s.getStudentId().equalsIgnoreCase(id));
    }

    public void listStudent() {
        for (Student s : students) {
            s.displayInfo();
        }
    }

}
