package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Student {
    static Logger l=Logger.getLogger("com.api.jar");
    String sname;
    String sgrade;
    double sgpa;
    double gpoint;

    public Student(String name, String grade, double gpa) {
        sname = name;
        sgrade = grade;
        sgpa = gpa;
    }

    void updategpa() {
        Scanner s = new Scanner(System.in);
        l.info("Enter the total credits:");
        double credit = s.nextDouble();
        switch (sgrade) {
            case "A" -> gpoint = 5.00;
            case "B" -> gpoint = 4.00;
            case "C" -> gpoint = 3.00;
            case "D" -> gpoint = 2.00;
            case "E" -> gpoint = 1.00;
            default -> l.info("invalid choice");
        }
        sgpa = (credit * gpoint) / credit;
        l.log(Level.INFO,()->"The gpa value of the student is:"+ sgpa);
    }
    String display() {
        return sname + " has a " + sgpa + " GPA";
    }

    public static void main(String[] args) {
         Logger l=Logger.getLogger("com.api.jar");
        Scanner s = new Scanner(System.in);
        String grade,name="";
        l.info("Enter the student name:");
        try{
            name = s.nextLine(); // null value
            System.out.println(name.charAt(7));
        }
        catch(IndexOutOfBoundsException e){
            l.log(Level.INFO, () -> "Index is out of bounds." + e);
            System.exit(0);

        }
        l.info("Enter the student total mark:");
        int marks = s.nextInt();
        if (marks > 400) {
            grade = "A";
        } else if (marks > 300) {
            grade = "B";
        } else if (marks > 200) {
            grade = "C";
        } else if (marks > 100) {
            grade = "D";
        } else {
            grade = "E";
        }
        l.log(Level.INFO,()->"The grade of the student is:"+grade);
        Student st = new Student(name, grade, 0.0);
        st.updategpa();
        l.log(Level.INFO,()-> st.display());
    }
}