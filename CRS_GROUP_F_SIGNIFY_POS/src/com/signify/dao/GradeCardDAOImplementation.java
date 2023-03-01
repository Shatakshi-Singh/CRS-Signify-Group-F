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
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.exception.UserNotFoundException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

public class GradeCardDAOImplementation implements GradeCardDAOInterface{

	Connection conn = null;
	PreparedStatement stmt = null;
	   
	public double calculateCpi(List<Course> courses){
		double cpi = 0.0d;
		for(Course c : courses)
		{
			try{
				  conn = DBUtils.getConnection();
			      String sql="select marks from grades where grade= \""+c.getGrade() +"\"";
			      stmt = conn.prepareStatement(sql);

			      ResultSet rs = stmt.executeQuery();
			      while(rs.next())
			      {
			    	  cpi+=rs.getInt("marks");
			    	  
			      }
			      cpi/=4;
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			     // e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		}
		return cpi;
	}
	@Override
	public List<Course> viewgrades(String userId) {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		try{
				  conn = DBUtils.getConnection();
			      String sql="select courseCode,grade from course_registration where studentId= \""+userId +"\"";
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next())
			      {
			    	  Course course = new Course();
			    	  course.setCourseCode(rs.getString("courseCode"));
			    	  course.setGrade(rs.getString("grade"));
			    	  courses.add(course);
			    	  
			      }
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			     // e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		return courses;
		
	}

	@Override
	public void update(String userId) {
		// TODO Auto-generated method stub
		try{
				  conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.UPDATE_GRADE_CARD);
			      
			      stmt.setString(1, userId); 
			      stmt.setInt(2, 5);
			      stmt.setInt(3, 0);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		
	}

	@Override
	public boolean view(String userId) throws NoCourseRegisteredException{
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
				conn = DBUtils.getConnection();
				stmt = conn.prepareStatement(SQLConstants.VIEW_REPORT_CARD+userId);
			      ResultSet rs = stmt.executeQuery();
			      
			      if (rs.next()) 
			    	  if(rs.getInt("visible")==0)
			    		  flag = false;
		                 else 
		                	 flag = true;
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new NoCourseRegisteredException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		
		return flag;
	}

	@Override
	public void generate() throws NoStudentsRegisteredForCourseException {
		// TODO Auto-generated method stub
		try{
			conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.GENERATE_REPORT_CARD);
			      //if(stmt.execute())
			    	 // throw new NoCourseRegisteredException();
			   	      

		           int row =stmt.executeUpdate();
		           if(row == 0)
		        	   throw new NoStudentsRegisteredForCourseException();
			      stmt.close();
			      
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new NoStudentsRegisteredForCourseException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   
			   }
	}

	
}
