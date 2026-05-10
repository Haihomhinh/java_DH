package com.pdhai.management_student_course;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.pdhai.management_student_course.Util.InputHelper;
import com.pdhai.management_student_course.model.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        int choice;

        do {
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = InputHelper.readInt(input);

            switch (choice) {
                case 0:
                    System.out.println("Exit your working!");
                    break;
                case 1:
                    System.out.println("\n--- STUDENT MANAGEMENT ---");
                    managerStudent(students);
                    break;
                case 2:
                    System.out.println("\n--- COURSE MANAGEMENT ---");
                    managerCourses(courses);
                    break;

            }
        } while (choice != 0);

        input.close();
    }

    public static void managerStudent(List<Student> students) {

        int choice;
        do {
            System.out.println("0. Back to Main Menu");
            System.out.println("1. Add student");
            System.out.println("2. Display student");
            System.out.println("3. Print Student Details");
            System.out.print("Enter choice: ");
            choice = InputHelper.readInt(input);

            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                case 1:
                    System.out.print("Enter student id: ");
                    String id = input.nextLine();
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    System.out.print("Enter student email: ");
                    String email = input.nextLine();
                    students.add(new Student(id, name, email));
                    break;

                case 2:
                    System.out.println("\n---------LIST OF STUDENTS------------");
                    if (!students.isEmpty()) {
                        for (Student s : students) {
                            s.displayInfo();
                        }
                    } else
                        System.out.println("NULL");

                    System.out.println("-------------------------------------\n");
                    break;
                
                case 3: 
                    System.out.print("Enter the student id that you want to find: ");
                    String studentId = input.nextLine();
                    Student s = findStudentEqualById(students, studentId);
                    printFollowID(s); // downcasting student to printable
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    public static void managerCourses(List<Course> courses) {
        int choice;
        do {
            System.out.println("0. Back to Main Menu"); // Đánh số 3 rõ ràng
            System.out.println("1. Add course");
            System.out.println("2. Display courses");
            System.out.println("3. Print Course Details");
            System.out.print("Enter choice: ");

            choice = InputHelper.readInt(input); // Dùng Helper để tránh trôi lệnh

            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                case 1:
                    System.out.print("Enter course id: ");
                    String id = input.nextLine();
                    System.out.print("Enter course name: ");
                    String name = input.nextLine();
                    System.out.print("Enter credits: ");
                    int credits = InputHelper.readInt(input);

                    System.out.print("Type (1. Online / 2. Offline): ");
                    int type = InputHelper.readInt(input);

                    if (type == 1) {
                        System.out.print("Enter platform: ");
                        String platform = input.nextLine();
                        courses.add(new OnlineCourse(id, name, credits, platform));
                    } else {
                        System.out.print("Enter location: ");
                        String location = input.nextLine();
                        courses.add(new OfflineCourse(id, name, credits, location));
                    }
                    break;

                case 2:
                    System.out.println("\n--- LIST OF COURSES ---");
                    if (courses.isEmpty()) {
                        System.out.println("List is empty!");
                    } else {
                        for (Course c : courses) {
                            c.displayInfo();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the id that you want to find: ");
                    String courseId = input.nextLine();
                    Course c = findCourseEqualById(courses, courseId);
                    printFollowID(c);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0); // Thoát khi chọn đúng số 0
    }

    public static Course findCourseEqualById(List<Course> courses, String id) {
        if (courses.isEmpty()) {
            return null;
        } else {
            for (Course c : courses) {
                if (c.getCourseId().equalsIgnoreCase(id)) {
                    return c;
                }
            }
        }
        return null;
    }
    
    public static Student findStudentEqualById(List<Student> students, String id) {
        if (students.isEmpty()) {
            return null;
        } else {
            for (Student s : students) {
                if (s.getStudentId().equalsIgnoreCase(id)) {
                    return s;
                }
            }
        }
        return null;
    }

    public static void printFollowID(Printable p) {
        if (p != null) {
            p.printDetails(); // Gọi qua interface reference như yêu cầu bài lab
        } else {
            System.out.println("Object is not exists!");
        }
    }
}

