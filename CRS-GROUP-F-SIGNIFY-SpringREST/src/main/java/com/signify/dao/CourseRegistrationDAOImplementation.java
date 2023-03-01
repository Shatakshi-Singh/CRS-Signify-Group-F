package com.signify.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.constants.SQLConstants;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotInRegisteredException;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.exception.PaymentDoneCourseNotAddedException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.UserNotFoundException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

public class CourseRegistrationDAOImplementation implements CourseRegistrationDAOInterface{

	Connection conn=null;
	PreparedStatement stmt=null;
	
	@Override
	public void addCourse(String student, String course) throws CourseAlreadyRegisteredException, PaymentDoneCourseNotAddedException{
		// TODO Auto-generated method stub
		if(getPaymentstatus(student)) {
			try
			{
				 conn = DBUtils.getConnection();
				
				stmt=conn.prepareStatement(SQLConstants.ADD_REGISTERED_COURSE);
				stmt.setString(1, student);
				stmt.setString(2,course);
		           int row =stmt.executeUpdate();
		           if(row == 0)
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
		else
			throw new PaymentDoneCourseNotAddedException();
	}

	@Override
	public void dropCourse(String student, String course) throws CourseNotInRegisteredException, PaymentDoneCourseNotAddedException{
		// TODO Auto-generated method stub
		if(getPaymentstatus(student)) {
			
			try
			{
				   conn = DBUtils.getConnection();
				   //System.out.println(SQLConstants.DELETE_REGISTERED_COURSE);
			      stmt = conn.prepareStatement(SQLConstants.DELETE_REGISTERED_COURSE);
		            // execute the delete statement
			      stmt.setString(1, course);
			      stmt.setInt(2, Integer.parseInt(student));
		           int row =stmt.executeUpdate();
		           if(row == 0)
		        	   throw new CourseNotInRegisteredException();
			      stmt.close();
			      //
			   }catch(SQLException e){
			      //Handle errors for JDBC
			      e.printStackTrace();

	        	   throw new CourseNotInRegisteredException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
			
		}else
			throw new PaymentDoneCourseNotAddedException();
	}

	@Override
	public List<Course> viewCourses(String student)throws NoCourseRegisteredException {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		 try{
			 	   conn = DBUtils.getConnection();
			      String sql = "SELECT * FROM course WHERE courseCode in (SELECT courseCode FROM course_registration where studentId = "+student +")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery();
			      boolean flag = true;
			    	  while(rs.next()){
			    		  	flag = false;
			    		  	Course course = new Course();
				    	  	course.setCourseCode(rs.getString("courseCode"));
					        course.setCourseName(rs.getString("courseName"));
					        course.setDepartmentName(rs.getString("departmentname"));
					        course.setSemester(rs.getString("semester"));
					        courses.add(course);
					      }
			      
			      if(flag)
			    	 throw new NoCourseRegisteredException();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      e.printStackTrace();

			    	  throw new NoCourseRegisteredException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		 return courses;
	}

	@Override
	public List<Student> viewStudents(String course) throws NoStudentsRegisteredForCourseException{
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		 try{
			  conn = DBUtils.getConnection();
			   
			      String sql = "SELECT studentId, studentName FROM students WHERE studentId in (SELECT studentId FROM course_registration where courseCode = \""+course +"\")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      boolean flag = true;
		    	  while(rs.next()){
		    		  	flag = false;
					      Student student = new Student();
					       	student.setUserId(rs.getString("studentId"));
					       	student.setStudentName(rs.getString("studentName"));
					         //Display values
					       	students.add(student);
					      }
			      
		    	  if(flag)
			    	  throw new NoStudentsRegisteredForCourseException();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			    	  throw new NoStudentsRegisteredForCourseException();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
		 
		 return students;
	}

	@Override
	public void addGrade(String student, String course, String grade) throws UserNotFoundException {
		// TODO Auto-generated method stub
		 try{
			  conn = DBUtils.getConnection();
			      String sql = "UPDATE course_registration SET grade = \""+grade+"\" WHERE studentId = "+student+" and courseCode = \""+course+"\"";

			      stmt = conn.prepareStatement(sql);

		           int row =stmt.executeUpdate();
		           if(row == 0)
			    	  throw new UserNotFoundException(student);
			      
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();

			    	  throw new UserNotFoundException(student);
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
	}

	@Override
	public boolean getPaymentstatus(String studentId) {
		// TODO Auto-generated method stub
		boolean status = true;
		try{
			  conn = DBUtils.getConnection();
			   
			      String sql = "SELECT registered FROM students WHERE studentId = "+studentId +")";

			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      if(rs.next()) {
			    	  if(rs.getInt("registered")== 1)
			    		  status = false;
			      }
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      //e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		return status;
	}
	@Override
	public int countCourseStudent(String student){
		// TODO Auto-generated method stub
		int count = 0;
		 try{
		 	   conn = DBUtils.getConnection();
		      String sql = "SELECT COUNT(*) AS total FROM course_registration WHERE studentId ="+student ;

		      stmt = conn.prepareStatement(sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      
		    	  if(rs.next())
		    		  count = rs.getInt("total");
				  else
					  throw new NoCourseRegisteredException();
		      stmt.close();
		      //
		      
		   }catch(SQLException e){		//Handle errors for JDBC
		      //e.printStackTrace();
		   }catch(Exception e){ 	      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
		return count;
	}

	@Override
	public boolean courseAvailableForSemester(String code, int sem) {
		// TODO Auto-generated method stub
		try{
			   conn = DBUtils.getConnection();
		      String sql="select semester from course where courseCode = \""+code+"\"";
		      stmt = conn.prepareStatement(sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      
	    	  if(rs.next())
	    		 if(rs.getInt("semester")== sem)
	    			 return true;
	    		 
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		   }catch(Exception e){
		      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
		   
		   return false;
	}

	@Override
	public boolean getStudent(String userId, String course) throws UserNotFoundException {
		 try{
			   conn = DBUtils.getConnection();
		      String sql="SELECT studentId FROM students WHERE studentId in (SELECT studentId FROM course_registration where studentId = "+userId+" and courseCode = \""+course +"\")";
		      stmt = conn.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();
				int id;
				if(rs.next())
				 id = rs.getInt(1);
				else
	        	  throw new UserNotFoundException(userId);
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC

	        	  throw new UserNotFoundException(userId);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
		   
		   return true;
	}

}
