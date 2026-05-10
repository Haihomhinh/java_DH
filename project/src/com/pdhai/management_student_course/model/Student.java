package com.pdhai.management_student_course.model;

public class Student {
    private String studentId;
    private String name;
    private String email;

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

    //-----------------------------------------
}
