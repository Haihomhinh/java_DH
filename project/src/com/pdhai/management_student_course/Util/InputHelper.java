package com.pdhai.management_student_course.Util;

import java.util.Scanner;

public class InputHelper {
    private InputHelper() {
    }

    public static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}


