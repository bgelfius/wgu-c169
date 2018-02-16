package com.c169;

import java.util.ArrayList;


public class Roster {

    private static ArrayList<Student> myStudents = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        addStudent(1, "John", "Smith", "John1989@gmail.com", 20, 88, 79, 59);
        addStudent(2, "Suzan", "Erickson", "Erickson_1990@gmailcom", 19, 91, 72, 85);
        addStudent(3, "Jack", "Napoli", "The_lawyer99yahoo.com", 19, 85, 84, 87);
        addStudent(4, "Erin", "Black", "Erin.black@comcast.net", 22, 91, 98, 82);
        addStudent(5, "Bryan", "Gelfius", "bgelfiu@wgu.edu", 47, 99, 98, 100);

        print_all();
        print_invalid_emails();

        for(int index = 0; index < myStudents.size(); index++) {
            print_average_grade(Integer.toString(myStudents.get(index).getStudentID()));
        }

        remove("3");
        remove("3");

    }

    public static void addStudent(int id, String fname, String lname, String email, int age, int grade1, int grade2, int grade3) {

        int[] grades = {grade1, grade2, grade3};
        Student nStudent = new Student(id, fname, lname, email, age, grades);
        myStudents.add(nStudent);

    }

    public static void remove(String studentID) {

        Student tmpStudent = findStudent(Integer.parseInt(studentID));

        if (tmpStudent == null) {
            System.out.println("Error: Student not found -- id[" + studentID + "]");
            return;
        }
        myStudents.remove(tmpStudent);
        System.out.println("Student " + studentID + " was removed ");

        //myStudents.
    }

    private static Student findStudent(int id) {

        for(int index=0; index < myStudents.size(); index++) {
            if(myStudents.get(index).getStudentID() == id) {
                return myStudents.get(index);
            }
        }
        return null;
    }

    public static void print_all() {

        for(int index = 0; index < myStudents.size(); index++) {
            myStudents.get(index).print();
        }
    }

    public static void print_average_grade(String studentID) {
        Student tmpStudent = findStudent(Integer.parseInt(studentID));

        int totalScore = 0;

        for (int index =0; index < tmpStudent.getGrades().length;index++) {
            totalScore += tmpStudent.getGrades()[index];
        }

        System.out.println("For student " + studentID + " the average grade is: " + Math.round( (float) totalScore/tmpStudent.getGrades().length) + "%");
    }

    public static void print_invalid_emails() {
        for(int index = 0; index < myStudents.size(); index++) {
            if (myStudents.get(index).getEmailaddress().contains(" ")) {
                System.out.println(myStudents.get(index).getEmailaddress() + " is an invalid Email address for student id: "  + myStudents.get(index).getStudentID());
            } else {

                if (!myStudents.get(index).getEmailaddress().contains("@")) {
                    System.out.println(myStudents.get(index).getEmailaddress() + " is an invalid Email address for student id: " + myStudents.get(index).getStudentID());
                } else if (!myStudents.get(index).getEmailaddress().contains(".")) {
                    System.out.println(myStudents.get(index).getEmailaddress() + " is an invalid Email address for student id: " + myStudents.get(index).getStudentID());
                }
            }
        }
    }
}
