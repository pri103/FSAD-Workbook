package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;

    @Autowired
    private Certification certification;

    public Student() {
        this.id = 1;
        this.name = "Priya";
        this.gender = "Female";
    }

    public void displayDetails() {
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Gender     : " + gender);
        System.out.println("Certification Details : ");
        System.out.println(certification);
    }
}
