package com.pdhai.management_student_course.model;

public class OfflineCourse extends Course{
    private String location;

    public OfflineCourse(String id, String name, int c, String loca) {
        super(id, name, c);
        this.location = loca;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Location: " + location);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Location: "+ location);
    }
}
