/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.Professor;
import com.signify.constants.SQLConstants;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.helper.IDs;
import com.signify.service.UserLoginServices;
import com.signify.utils.DBUtils;

/**
 * @author GROUP H
 *
 */
public class ProfessorDAOImplementation implements ProfessorDAOInterface{
	

	   Connection conn = null;
	   PreparedStatement stmt = null;
	public boolean getProfessor(String userId) throws ProfessorNotFoundException {

		   try{
			   conn = DBUtils.getConnection();
		      String sql="select * from professors where profId = "+userId;
		      stmt = conn.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();
				int id;
				if(rs.next())
				 id = rs.getInt(1);
				else
	        	  throw new ProfessorNotFoundException(userId);
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC

	        	  throw new ProfessorNotFoundException(userId);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		     // e.printStackTrace();
		   }
		   
		   return true;
	}
	@Override
	public void insert(int id, Professor professor) {
		// TODO Auto-generated method stub
		 
		   try{
			   	conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.ADD_PROFESSOR);
			   
			      stmt.setInt(1, id); 
			      stmt.setString(2,professor.getDesignation());
			      stmt.setString(3, professor.getProfessorName());
			      stmt.setString(4, professor.getDepartmentName());
			      stmt.setString(5, professor.getPhoneNumber());
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			     // e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     //e.printStackTrace();
			   }
	}

	@Override
	public void delete(String professorId) throws ProfessorNotFoundException {
		// TODO Auto-generated method stub
		
		   try{
			   conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLConstants.DELETE_PROFESSOR);
		      stmt.setInt(1, Integer.parseInt(professorId)); 
	           int row = stmt.executeUpdate();
	           if(row == 0)
	        	   throw new ProfessorNotFoundException(professorId);
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		     //e.printStackTrace();

        	   throw new ProfessorNotFoundException(professorId);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		    // e.printStackTrace();
		   }
		
	}

	@Override
	public void view(String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String update, String id, String field) throws ProfessorNotFoundException{
		// TODO Auto-generated method stub
		try{

			conn = DBUtils.getConnection();
			      String sql="update professors set ";
			      switch(field) {
					case "1": sql+="professorName = "+update;
					break;
					case "2":sql+="designation = "+update;
					break;
					case "3": sql+="departmentName = "+update;
					break;
					case "5":sql+="phoneNumber = "+update;
					break;
					default : System.out.println("Enter valid numeric input.");
					}
			      sql+="where profId = "+id;
			      stmt = conn.prepareStatement(sql);
			      int row = stmt.executeUpdate();
		           if(row == 0)
		        	   throw new ProfessorNotFoundException(id);
			      stmt.close();
			      //
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			     // e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      //e.printStackTrace();
			   }
	}

	
	

}
