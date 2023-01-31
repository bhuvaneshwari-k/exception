package org.example;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
class Database {
    Logger l=Logger.getLogger("com.api.jar");
    static Database db;
    Connection conn;
    private  Database(){}
    public static Database getdatabase(){
        if(db==null)
            db=new Database();
        return db;
    }
    void newConnection(String url1,String user1,String pass1) throws SQLException{
        conn= DriverManager.getConnection(url1,user1,pass1);
        l.info("Connection created");
    }
    void closeConnection() throws SQLException{
        conn.close();
        l.info("Connection destroyed");
    }
    public static void main(String[] args) throws SQLException {
        Scanner s=new Scanner(System.in);
        Logger l=Logger.getLogger("com.api.jar");
        l.info("Enter the url:");
        String url=s.nextLine();
        l.info("Enter the username:");
        String user=s.nextLine();
        l.info("Enter the password:");
        String pass=s.nextLine();
        Database d1=Database.getdatabase();
        d1.newConnection(url,user,pass);
        d1.closeConnection();
    }
}
