package com.pdhai.management_student_course.model;

public class OnlineCourse extends Course{
    private String platform;

    public OnlineCourse(String id, String name, int c, String plat) {
        super(id, name, c);
        this.platform = plat;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
    }
}
