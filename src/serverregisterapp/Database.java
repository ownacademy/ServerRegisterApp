/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverregisterapp;

import java.sql.*;

/**
 *
 * @author Ivan
 */
public class Database {
       // JDBC driver name and database URL
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       static final String DB_URL = "jdbc:mysql://localhost/db_servers";

       //  Database credentials
       static final String USER = "root";
       static final String PASS = "64Bxx8";
    
    public static boolean INSERT_SERVER_DATA(ServerData data){
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
          
            String sqlInstert = "INSERT INTO list " +
                                "VALUES ('"+data.ID+"', '"+data.SERVER_NAME+"', '"+data.SERVER_IP+"', '"+data.DOCKER_STATUS+"')";
            stmt.executeUpdate(sqlInstert);
            System.out.println("Inserted records into the table...");
           
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
