/**
 * 
 */
package com.signify.dao;

import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.NoApprovedStudentsException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.exception.UserNotFoundException;

/**
 * @author GROUP H
 *
 */
public interface StudentDAOInterface {
	
	/*
	 method to add the student 
	 @param id   unique id to represent the student
	 @param student  student object of class Student
	 */
	public void add(int id, Student student);
	
	/*
	 method to delete the student 
	 @param query   represents the query 
	 */
	public void delete(String query);
	
	/*
	 method to update the student 
	 @param query   represents the query 
	 */
	public void update(String query);
	
	/* 
	 method to view the student
	 */
	public List<Student> view() throws NoApprovedStudentsException;
	
	/*
	 method to approve all the students 
	 @param query   represents the query 
	 */
	public void approveAll()throws StudentNotFoundForApprovalException;
	
	/**
	 * method to approve the student
	 * @param id
	 * @throws StudentNotFoundForApprovalException
	 * @throws UserNotFoundException
	 */
	public void approve(String id)throws StudentNotFoundForApprovalException, UserNotFoundException;
	
	/**
	 * method for student registration
	 * @param userId
	 */
	public void registered(String userId);
	
	/**
	 * method to get the semester number
	 * @param userId
	 * @return return semester number
	 */
	public int getSem(String userId);
}
