package com.signify.dao;

import java.util.List;

import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.exception.NoProfessorInDatasetException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.exception.UserNotFoundException;

public interface UserDAOInterface {
	
	/**
	 * method to add the user
	 * @param user
	 * @param role
	 * @return returns the role of the user
	 */
	public int add(User user, int role);
	
	/**
	 * method to update the user
	 * @param quer
	 */
	public void update(String quer);
	
	/**
	 * method to update the user password
	 * @param userId
	 * @param password
	 */
	public void updatePassword(String userId, String password);
	
	/**
	 * method to delete the user
	 * @param userId
	 * @throws UserNotFoundException
	 */
	public void delete(String userId) throws UserNotFoundException;
	
	/**
	 * method to authenticate the user
	 * @param password
	 * @param userId
	 * @return authentication status of user
	 */
	public int authenticate(String password,String userId);
	
	/**
	 * method to unapprove the student
	 * @throws StudentNotFoundForApprovalException
	 */
	public List<Student> getUnapproved() throws StudentNotFoundForApprovalException;
	
	/**
	 * method to print the professor
	 * @return 
	 * @throws NoProfessorInDatasetException
	 */
	public List<Professor> printProfessors() throws NoProfessorInDatasetException;
	
	/**
	 * method to get the role of user
	 * @param userId
	 * @return returns the type of role of the user
	 */
	public int getRole(String userId);
	
	/**
	 * method to return the count of the users
	 * @return returns the count of the users
	 */
	public int count();
	
	/**
	 * method to update the student
	 * @param userId
	 * @throws UserNotFoundException
	 */
	public void updateStudent(int userId) throws UserNotFoundException;
	
	/**
	 * method to approveAll users
	 * @throws StudentNotFoundForApprovalException
	 */
	public void approveAll() throws StudentNotFoundForApprovalException;

}
