/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Course;
import com.signify.constants.SQLConstants;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GROUP H
 *
 */
public class CourseDAOImplementation implements CourseDAOInterface {

	
	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void add(Course course) throws CourseAlreadyRegisteredException {
		// TODO Auto-generated method stub
		try
		{
			conn = DBUtils.getConnection();
			stmt=conn.prepareStatement(SQLConstants.ADD_COURSE);
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2,course.getCourseName());
			stmt.setString(3, course.getDepartmentName());
			stmt.setString(4, course.getSemester());

			if(stmt.execute())
				throw new CourseAlreadyRegisteredException();
			stmt.close();
			//
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new CourseAlreadyRegisteredException();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}

	@Override
	public void remove(String courseCode) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		try
		{
			  conn = DBUtils.getConnection();
		      
		      stmt = conn.prepareStatement(SQLConstants.DELETE_COURSE);
		      stmt.setString(1, courseCode);

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
		     // e.printStackTrace();
		   }
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Course> view() throws NoCourseException{
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		 try{
			 	  conn = DBUtils.getConnection();
			 	   //System.out.println(SQLConstants.VIEW_COURSES);
			 	  stmt = conn.prepareStatement(SQLConstants.VIEW_COURSES);
			      ResultSet rs = stmt.executeQuery();
			    
			      boolean flag = true;

				      while(rs.next()){
					         //Retrieve by column name
				    	  flag = false;
				    	  	Course course = new Course();
				    	  	course.setCourseCode(rs.getString("courseCode"));
					        course.setCourseName(rs.getString("courseName"));
					        course.setDepartmentName(rs.getString("departmentname"));
					        course.setSemester(rs.getString("semester"));
					        courses.add(course);
					       }
				      if(flag)
			    	  throw new NoCourseException();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      ////e.printStackTrace();
				   throw new NoCourseException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		 return courses;
	}

	@Override
	public List<Course> viewCoursesForSemester(int sem) throws NoCourseException {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		try{
		 	  conn = DBUtils.getConnection();
		 	  stmt = conn.prepareStatement(SQLConstants.VIEW_COURSES_FOR_SEM+Integer.toString(sem));
		      ResultSet rs = stmt.executeQuery();
		    
		      boolean flag = true;

			      while(rs.next()){
			    	  flag = false;
			    	  Course course = new Course();
			    	  	course.setCourseCode(rs.getString("courseCode"));
				        course.setCourseName(rs.getString("courseName"));
				        course.setDepartmentName(rs.getString("departmentname"));
				        courses.add(course);
				      }
			      if(flag)
		    	  throw new NoCourseException();
		      stmt.close();
		      //
		      
		   }catch(SQLException e){		//Handle errors for JDBC
		      ////e.printStackTrace();
			   throw new NoCourseException();
		   }catch(Exception e){ 	      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
		 return courses;
	}

}
