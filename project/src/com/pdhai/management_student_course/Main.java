package com.pdhai.management_student_course;

import java.util.Scanner;
import java.util.ArrayList;

import com.pdhai.management_student_course.Util.InputHelper;
import com.pdhai.management_student_course.model.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = InputHelper.readInt(input);

            switch (choice) {
                case 1:
                    managerStudent(students);
                    break;
                case 2:
                    break;
            }
        } while (choice != 3);

        input.close();
    }

    public static void managerStudent(ArrayList<Student> students) {

        int choice;
        do {
            System.out.println("1. Add student");
            System.out.println("2. Display student");
            System.out.println("3. Exit");
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
                    if (!students.isEmpty()) {
                        System.out.println("\n-------------------------------------");
                        for (Student s : students) {
                            s.displayInfo();
                        }
                        System.out.println("-------------------------------------\n");

                    }
                    System.out.println("NULL");
                    break;
            }

        } while (choice != 3);
    }
}
