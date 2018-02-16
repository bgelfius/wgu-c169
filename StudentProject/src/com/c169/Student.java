package com.c169;

import java.lang.reflect.Array;

public class Student {
    private int studentid;
    private String firstname;
    private String lastname;
    private String emailaddress;
    private int age;
    private int[] grades;

    private int gradeIndex;
    private static final int maxGrades = 3;

    // constructors
    public Student() {
        this.grades = new int[maxGrades];
        this.gradeIndex = 0;
    }
    public Student(int id, String fname, String lname, String email, int age, int [] grades) {
        this.setStudentID(id);
        this.setFirstname(fname);
        this.setLastname(lname);
        this.setEmailAddress(email);
        this.setAge(age);

        //define grades as maxGrades item int array
        this.grades = new int[maxGrades];
        this.gradeIndex = 0;
        this.addGrades(grades);

    }

    //methods
    public void setStudentID(int sid) {
        this.studentid = sid;
    }
    public int getStudentID() {
        return studentid;
    }
    public void setFirstname(String fname) {
        this.firstname = fname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setLastname(String lname) {
        this.lastname = lname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setEmailAddress(String email) {
        this.emailaddress = email;
    }
    public String getEmailaddress() {
        return emailaddress;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void addGrades(int[] grades) {
        this.grades = grades;
    }
    public int[] getGrades() {
        return grades;
    }

    public void print() {
        System.out.println("StudentID:\t" + getStudentID() +
                            "\tFirst Name:\t" + getFirstname() +
                            "\tLast Name:\t" + getLastname() +
                            "\tEmail Address:\t" + getEmailaddress() +
                            "\tAge:\t" + getAge() +
                            "\tGrades:\t");

        boolean firstTime = true;

        for (int grade: getGrades()) {
            if (!firstTime) {
                System.out.print(",");
            }
            System.out.print(grade);
            firstTime = false;
        }
        System.out.println("");

    }

}

