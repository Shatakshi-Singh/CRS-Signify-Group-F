/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;
import com.signify.constants.SQLConstants;
import com.signify.exception.CourseNotAssignedToProfessorException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

/**
 * @author GROUP H 
 *
 */
public class CatelogDAOImplementation implements CatelogDAOInterface {

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void add(String profid, String courseCode) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		try
		{
			 conn = DBUtils.getConnection();
			stmt=conn.prepareStatement(SQLConstants.ADD_CP_IN_CATELOG);
			stmt.setString(1, courseCode);
			stmt.setString(2,profid);
			if(stmt.execute())
				throw new CourseNotFoundException(courseCode);
			stmt.close();
			//
		}
		catch(SQLException e)
		{
			//e.printStackTrace();

			throw new CourseNotFoundException(courseCode);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}

	@Override
	public void remove(String courseCode) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			 conn = DBUtils.getConnection();
		     
		      stmt = conn.prepareStatement(SQLConstants.DELETE_CP_IN_CATELOG+courseCode);

	           int row =stmt.executeUpdate();
	           if(row == 0)
	        	   throw new CourseNotFoundException(courseCode);
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		      //e.printStackTrace();

        	   throw new CourseNotFoundException(courseCode);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      //e.printStackTrace();
		   }
	}

	@Override
	public List<Course> getCourse(String prof)throws CourseNotAssignedToProfessorException {
		// TODO Auto-generated method stub
		 List<Course> course = new ArrayList<>();
		try{
			 conn = DBUtils.getConnection();
			 stmt = conn.prepareStatement(SQLConstants.GET_COURSE+prof);
			      ResultSet rs = stmt.executeQuery();
			     boolean flag = true;
			      while (rs.next()) {
			    	  flag = false;
			    	  Course c = new Course();
			    	  c.setCourseCode((rs.getString("course")));
		              course.add(c);
			      }
			      if (flag)
			      throw new CourseNotAssignedToProfessorException();
		                	 
			      
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			    	  throw new CourseNotAssignedToProfessorException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		
		
		return course;
	}

}
