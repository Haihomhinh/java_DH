package com.pdhai.management_student_course.Data;

import java.util.Map;
import java.util.HashMap;
import com.pdhai.management_student_course.model.*;

public class DataManager {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();

    public DataManager() {
    }

    //add
    public void addStudent(Student s) {
        if (s == null) {
            System.out.println("Invalid input!");
            return;
        }
        if (students.containsKey(s.getStudentId())) {
            System.out.println("Error: Student ID [" + s.getStudentId() + "] has existed in the system!");
            return;
        }

        students.put(s.getStudentId(), s);
    }

    public void addCourse(Course c) {
        if (c == null) {
            System.out.println("Invalid input!");
            return;
        }
        if (courses.containsKey(c.getCourseId())) {
            System.out.println("Error: COurse ID [" + c.getCourseId() + "] has existed in the system!");
            return;
        }

        courses.put(c.getCourseId(), c);
    }

    // Find id
    public Student findStudentById(String id) {
        return students.get(id);
    }

    public Course findCourseById(String id) {
        return courses.get(id);
    }

    //Getter for taking list
    public Map<String, Student> getListStudents() {
        return students;
    }

    public Map<String, Course> getListCourses(){
        return courses;
    }

}
