package org.example;
import java.util.logging.*;
import java.util.*;

class Shape {
    int stype;
    double a;
    double p;
    double l;
    double b;
    double s1;
    double s2;
    double r;
    double pi = 3.14;

    public Shape(int type, double length, double breadth, double side1, double side2, double radius) {
        stype = type;
        l = length;
        b = breadth;
        s1 = side1;
        s2 = side2;
        r = radius;
    }

    double perimeter() {
        if (stype == 1) {
            p = 2 * (l + b);
        }
        if (stype == 2) {
            p = b + s1 + s2;
        }
        if (stype == 3) {
            p = 2 * pi * r;
        }
        return p;
    }

    double area() {
        if (stype == 1) {
            a = l * b;
        }
        if (stype == 2) {
            a = (b * l) / 2;
        }
        if (stype == 3) {
            a = pi * r * r;
        }
        return a;
    }

    public static void main(String[] args) {
        Logger l=Logger.getLogger("com.api.jar");
        double length=0;
        double breadth=0;
        double side1=0;
        double side2=0;
        double radius=0;
        Scanner s = new Scanner(System.in);
        try{
            l.info("Enter the length:");
            length = s.nextFloat();
            l.info("Enter the breadth:");
            breadth = s.nextFloat();
            l.info("Enter the side1:");
            side1 = s.nextFloat();
            l.info("Enter the side2:");
            side2 = s.nextFloat();
            l.info("Enter the radius:");
            radius = s.nextFloat();
        }
        catch (InputMismatchException e){
            l.log(Level.INFO, () -> "Input is mismatched." + e);
            System.exit(0);

        }
        l.info("choose one from below.");
        l.info("1.Rectangle\n2.Triangle\n3.Circle");
        l.info("Enter the shape type:");
        int type = s.nextInt();
        Shape sh = new Shape(type, length, breadth, side1, side2, radius);
        l.log(Level.INFO, () -> "The perimeter of the given shape is:" +sh.perimeter());
        l.log(Level.INFO, () -> "The area of the given shape is:" +sh.area());
        s.close();
    }

}