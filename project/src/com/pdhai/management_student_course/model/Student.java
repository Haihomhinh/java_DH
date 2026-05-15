package com.pdhai.management_student_course.model;

import java.util.List;
import java.util.ArrayList;

public class Student implements Printable{
    private String studentId;
    private String name;
    private String email;
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String id, String n, String e) {
        studentId = id;
        name = n;
        email = e;
    }

    //----------setter and getter--------------
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //-----------------------------------------

    public void displayInfo() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Email: " + email);
    }

    @Override
    public void printDetails() {
        displayInfo();
    }

    public void enrollCourse(Course course) {
        if (course == null) {
            System.out.println("Invalid input!");
            return;
        }

        enrolledCourses.add(course);
    }
    
    public void listCourse() {
        System.out.println("-------All enrolled courses:----------");
        if (enrolledCourses.isEmpty()) {
            System.out.println("Nothing!");
            return;
        }
        for (Course c : enrolledCourses) {
            c.displayInfo();
        }
    }

    public void removeCourse(String id) {
        for (Course c : enrolledCourses) {
            if (c.getCourseId().equalsIgnoreCase(id)) {
                enrolledCourses.remove(c);
                break;
            }
        }
    }
    

}
