package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Space implements Cloneable {
    Logger l = Logger.getLogger("com.api.jar");
    String x1 = "20";
    String y1 = "30";
    String x2;
    String y2;

    Space(String x, String y) {
        x2 = x;
        y2 = y;
    }

    String comparing() {
        if (x1.equals(x2) && y1.equals(y2)) {
            return "true";
        } else {
            return "false";
        }
    }

    Space cloneTest() {
        try {
            return (Space) super.clone();
        } catch (CloneNotSupportedException e) {
            l.info("cloning not supported");
            return this;
        }
    }

    public static void main(String[] args){
        Logger l = Logger.getLogger("com.api.jar");
        Scanner s = new Scanner(System.in);
        l.info("Enter x co-ordinate:");
        String x = s.nextLine();
        l.info("Enter y co-ordinate:");
        String y = s.nextLine();
        Space sp1 = new Space(x, y);
        String result = sp1.comparing();
        l.log(Level.INFO, () -> "The new point p(x2,y2) is: P(" + sp1.x2 + "," + sp1.y2 + ")");
        if (result.equals("true")) {
            l.info("Both the points p(x1,y1) and p(x2,y2) are equal.");
        } else {
            l.info("Both the points p(x1,y1) and p(x2,y2) are not equal.");
        }
        Space sp2 = sp1.cloneTest();
        l.log(Level.INFO, () -> "The new cloned point p(x2,y2) is: P(" + sp2.x2 + "," + sp2.y2 + ")");
    }

}