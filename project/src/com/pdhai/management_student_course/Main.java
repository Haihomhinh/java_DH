package com.pdhai.management_student_course;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import com.pdhai.management_student_course.Util.InputHelper;
import com.pdhai.management_student_course.model.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Course> courses = new HashMap<>();// <id, course>
        Map<String, Student> students = new HashMap<>(); // <id, student>
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
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        input.close();
    }

    public static void managerStudent(Map<String, Student> students) {

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
                    students.put(id, new Student(id, name, email));
                    break;

                case 2:
                    System.out.println("\n---------LIST OF STUDENTS------------");
                    if (!students.isEmpty()) {
                        for (Map.Entry<String, Student> s : students.entrySet()) {
                                s.getValue().displayInfo();
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

    public static void managerCourses(Map<String, Course> courses) {
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
                        courses.put(id, new OnlineCourse(id, name, credits, platform));
                    } else {
                        System.out.print("Enter location: ");
                        String location = input.nextLine();
                        courses.put(id, new OfflineCourse(id, name, credits, location));
                    }
                    break;

                case 2:
                    System.out.println("\n--- LIST OF COURSES ---");
                    if (courses.isEmpty()) {
                        System.out.println("List is empty!");
                    } else {
                        for (Map.Entry<String, Course> c: courses.entrySet()) {
                            c.getValue().displayInfo();
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

    public static Course findCourseEqualById(Map<String, Course> courses, String id) {
        if (courses.isEmpty()) {
            return null;
        } else {
            for (Map.Entry<String, Course> c : courses.entrySet()) {
                if (c.getKey() == id) {
                    return c.getValue();
                }
            }
        }
        return null;
    }
    
    public static Student findStudentEqualById(Map<String, Student> students, String id) {
        if (students.isEmpty()) {
            return null;
        } else {
            for (Map.Entry<String, Student> s : students.entrySet()) {
                if (s.getKey() == id) {
                    return s.getValue();
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

