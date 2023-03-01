/**
 * 
 */
package com.signify.utils;

/**
 * @author GROUP-E-CRS-SIGNIFY
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
         /**
		 This Method Is Used to make the connection with the Database 
		 with the help of driver and the exception are being handled .
		 
		 
		 
		 
		 
		 **/
	private static Connection conn = null;
	
	public static Connection getConnection(){
		
        if (conn != null)
            return conn;
        else {
            try {
            	Properties prop = new Properties();
            	//System.out.println("in stream ");
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
                
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
//            	String driver = "com.mysql.jdbc.Driver"; 
//            	String url =  "jdbc:mysql://localhost/crs-database";
//            	String user = "root";
//            	String password = "Password@1";
                //Class.forName(driver);
//                System.out.println("URL--> " +url + "user-->" +user + "password-->" +password);
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
          } 
                catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return conn;
        }

    }


}
