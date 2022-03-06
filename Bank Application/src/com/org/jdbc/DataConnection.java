package com.org.jdbc;
import java.sql.*;
public class DataConnection {
    private static Connection con;
    public static Connection getConnection()
    {
        try
        {
           if(con==null)
           {
                //driver class load   
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("Driver registered..");
                    //create a connection..

                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","1234");
            
                     System.out.println("Connection Established..");
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
}
