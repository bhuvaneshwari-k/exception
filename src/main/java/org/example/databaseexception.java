package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
 class database {
    static database db;
    Connection conn;
    private database(){}
    public static database getdatabase(){
        if(db==null)
            db=new database();
        return db;
    }
    void newConnection(String url1,String user1,String pass1) throws SQLException{
        conn= DriverManager.getConnection(url1,user1,pass1);
        System.out.println("Connection created");
    }
    void closeConnection() throws SQLException{
        conn.close();
        System.out.println("Connection destroyed");
    }
    public static void main(String[] args) throws SQLException {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the url:");
    String url=s.nextLine();
        System.out.println("Enter the username:");
    String user=s.nextLine();
        System.out.println("Enter the password:");
    String pass=s.nextLine();
    database d1=database.getdatabase();
    d1.newConnection(url,user,pass);
    d1.closeConnection();
    }
}