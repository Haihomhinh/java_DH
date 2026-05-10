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
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = InputHelper.readInt(input);

            switch (choice) {
                case 1:
                    System.out.println("\n--- STUDENT MANAGEMENT ---");
                    managerStudent(students);
                    break;
                case 2:
                    System.out.println("\n--- COURSE MANAGEMENT ---");
                    managerCourses(courses);
                    break;
            }
        } while (choice != 3);

        input.close();
    }

    public static void managerStudent(List<Student> students) {

        int choice;
        do {
            System.out.println("1. Add student");
            System.out.println("2. Display student");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = InputHelper.readInt(input);

            switch (choice) {
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
                    }
                    else 
                        System.out.println("NULL");

                    System.out.println("-------------------------------------\n");
                    break;
                
                case 3:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    public static void managerCourses(List<Course> courses) {
        int choice;
        do {
            System.out.println("1. Add course");
            System.out.println("2. Display courses");
            System.out.println("3. Back to Main Menu"); // Đánh số 3 rõ ràng
            System.out.print("Enter choice: ");
            
            choice = InputHelper.readInt(input); // Dùng Helper để tránh trôi lệnh

            switch (choice) {
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
                    } 
                    else {
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
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3); // Thoát khi chọn đúng số 3
    }
}
