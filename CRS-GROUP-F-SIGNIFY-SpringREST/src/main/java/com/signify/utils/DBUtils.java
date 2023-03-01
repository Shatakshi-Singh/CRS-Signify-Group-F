/**
 * 
 */
package com.signify.utils;

/**
 * @author GROUP-H-CRS-SIGNIFY
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
		 with the help of driver and the com.signify.exception are being handled .
		 
		 
		 
		 
		 
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
                //String url = "jdbc:mysql://localhost/crs-database";
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                //String password = "123456";
                //Class.forName(driver);
               //System.out.println("URL--> " +url + "user-->" +user + "password-->" +password);
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
          } 
                catch (FileNotFoundException e) 
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return conn;
        }

    }


}
