/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.constants.SQLConstants;
import com.signify.exception.NoProfessorInDatasetException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.exception.UserNotFoundException;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

/**
 * @author GROUP H
 *
 */
public class UserDAOImplementation implements UserDAOInterface {

	Connection conn = null;
	PreparedStatement stmt = null;

	@Override
	public int add(User user, int role) {
		// TODO Auto-generated method stub
		int userId = -5;
		System.out.println("inside user add");
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.ADD_USER, 1);
			// System.out.println(SQLConstants.ADD_USER);
			// int userid=Integer.parseInt(user.getUserId());

			String name = user.getName();
			String password = user.getPassword();

			// stmt.setInt(1, userId);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setInt(3, role);

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				userId = rs.getInt(1);
				System.out.println("Your user Id is : "+userId);
			} else {
				System.out.println("User could not be added.");
			}
			stmt.close();
			//

		} catch (SQLException e) { // Handle errors for JDBC
			 e.printStackTrace();
		} catch (Exception e) { // Handle errors for Class.forName
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public void update(String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try{
			   conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLConstants.DELETE_USER);
		      stmt.setInt(1, Integer.parseInt(userId)); 
		      int row = stmt.executeUpdate();
	           if(row == 0)
	        	   throw new UserNotFoundException(userId);
		     
		      stmt.close();
		      //
		   }catch(SQLException e){
		      //Handle errors for JDBC
		     //e.printStackTrace();
     	   throw new UserNotFoundException(userId);
		   }catch(Exception e){
		      //Handle errors for Class.forName
		    // e.printStackTrace();
		   }

	}

	@Override
	public int authenticate(String passwordUser, String userId) {
		// TODO Auto-generated method stub

		try {
			conn = DBUtils.getConnection();
			String sql = "select name,password,role_id from users where userId = " + Integer.parseInt(userId);

			stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, Integer.parseInt(userId));
			ResultSet rs = stmt.executeQuery(sql);
			String password;
			String name;
			int role = 0;
			if (rs.next()) {
				password = rs.getString("password");
				if (passwordUser.equals(password)) {
					role = rs.getInt("role_id");
					name = rs.getString("name");
					System.out.print("\n      Hi " + name);
				} else
					role = 99999;
			}
			stmt.close();
			//
			return role;

		} catch (SQLException e) { // Handle errors for JDBC
			// e.printStackTrace();
		} catch (Exception e) { // Handle errors for Class.forName
			e.printStackTrace();
		}
		return 9;
	}

	@Override
	public List<Student> getUnapproved() throws StudentNotFoundForApprovalException {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList();
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.GET_UNAPPROVED_STUDENTS);
			ResultSet rs = stmt.executeQuery();

			boolean flag = true;
			
			while (rs.next()) {
				flag = false;
				Student student = new Student();
				student.setStudentName(rs.getString("name"));
				student.setUserId(Integer.toString(rs.getInt("userId")));
			}
			if (flag)
				throw new StudentNotFoundForApprovalException();
			stmt.close();
			//

		} catch (SQLException e) { // Handle errors for JDBC
			 //e.printStackTrace();
			throw new StudentNotFoundForApprovalException();
		} catch (Exception e) { // Handle errors for Class.forName
			//e.printStackTrace();

		} // end try
		
		return students;
	}

	public void approveAll() throws StudentNotFoundForApprovalException {
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_ALL_STUDENTS);
			 int row = stmt.executeUpdate();
	           if(row == 0)
				throw new StudentNotFoundForApprovalException();
			stmt.close();
			//

		} catch (SQLException e) { // Handle errors for JDBC
			//e.printStackTrace();

			throw new StudentNotFoundForApprovalException();
		} catch (Exception e) { // Handle errors for Class.forName
			//e.printStackTrace();

		} // end try
	}
	@Override
	public List<Professor> printProfessors() throws NoProfessorInDatasetException {
		// TODO Auto-generated method stub
		List<Professor> professors = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.PRINT_PROFESSORS);
			ResultSet rs = stmt.executeQuery();
			boolean flag = true;
			while (rs.next()) {
				flag = false;
				Professor professor =  new Professor();
				professor.setProfessorName(rs.getString("name"));;
				professor.setUserId(Integer.toString(rs.getInt("userId")));
				// Display values
			}
			if(flag)
				throw new NoProfessorInDatasetException();
			stmt.close();
			

		} catch (SQLException e) { // Handle errors for JDBC
			// e.printStackTrace();

			throw new NoProfessorInDatasetException();
		} catch (Exception e) { // Handle errors for Class.forName
			//e.printStackTrace();

		} // end try
		return professors;
	}

	@Override
	public int getRole(String userId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DBUtils.getConnection();
			String sql = "select role_id from users where userId = " + Integer.parseInt(userId);

			stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, Integer.parseInt(userId));
			ResultSet rs = stmt.executeQuery(sql);

			int role = 0;
			if (rs.next()) {
				role = rs.getInt("role_id");
				// System.out.println("The password for user " + password);

			} else {
				role = 5;
			}
			System.out.println("=================================");
			stmt.close();
			//
			return role;

		} catch (SQLException e) { // Handle errors for JDBC
			// e.printStackTrace();
		} catch (Exception e) { // Handle errors for Class.forName
			//e.printStackTrace();

		} // end try
		return 9;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub

		int countId = 1;
		/*
		 * try{ conn = DBUtils.getConnection();
		 * 
		 * stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql);
		 * if(rs.next()) countId = rs.getInt("total"); else
		 * System.out.println("There was some error."); stmt.close(); //
		 * 
		 * 
		 * }catch(SQLException e){ //Handle errors for JDBC //e.printStackTrace();
		 * }catch(Exception e){ //Handle errors for Class.forName //e.printStackTrace();
		 * }finally{ //finally block used to close resources try{ if(stmt!=null)
		 * stmt.close(); }catch(SQLException e2){ } try{ if(conn!=null) //
		 * }catch(SQLException e){ //e.printStackTrace(); }//end finally try }//end try
		 */
		return countId;
	}

	@Override
	public void updateStudent(int userID) throws UserNotFoundException {
		// TODO Auto-generated method stub'
		try {
			conn = DBUtils.getConnection();
			String sql = "update users set role_id = 2 where userId = " + Integer.toString(userID);
			stmt = conn.prepareStatement(sql);
			 int row = stmt.executeUpdate();
	           if(row == 0)
				throw new UserNotFoundException(Integer.toString(userID));

			// stmt.executeUpdate();
			stmt.close();
			//

		} catch (SQLException e) { // Handle errors for JDBC
			// e.printStackTrace();
			throw new UserNotFoundException(Integer.toString(userID));
		} catch (Exception e) { // Handle errors for Class.forName
			//e.printStackTrace();
			throw new UserNotFoundException(Integer.toString(userID));
		}

	}

	@Override
	public void updatePassword(String userId, String password) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();
			String sql = "update users set password = \"" + password + "\" where userId = " + userId;
			// System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			 int row = stmt.executeUpdate();
	           if(row == 0)
	        	   throw new UserNotFoundException(userId);
			else
				System.out.println("Password updated.");
			// stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) { // Handle errors for JDBC
			// e.printStackTrace();
		} catch (Exception e) { // Handle errors for Class.forName
			//e.printStackTrace();
		}

	}

}
