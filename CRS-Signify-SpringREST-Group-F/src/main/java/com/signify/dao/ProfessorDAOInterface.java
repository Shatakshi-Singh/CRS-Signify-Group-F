/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Professor;
import com.signify.exception.ProfessorNotFoundException;

/**
 * @author GROUP H
 *
 */
public interface ProfessorDAOInterface {
	
	/*
	 method to update the existing professor details
	 @param field   represents the field that needs to be updated
	 @param update  represents the update
	 @param id   unique id to represent the professor
	 */
	public void update(String update, String id, String field) throws ProfessorNotFoundException;
	
	/*
	 method to insert the professor
	 @param professor  professor object of Class professor
	 @param id   unique id to represent the professor
	 */
	public void insert(int id, Professor professor);
	
	/*
	 method to delete the professor
	 @param professorId   unique id to represent the professor
	 */
	public void delete(String profeessorId) throws ProfessorNotFoundException;
	
	/*
	 method to view the professor
	 @param query   represents the query
	 */
	public void view(String query);
	
	/*
	 method to get the professor
	 @param userId   unique id to represent the user
	 */
	public boolean getProfessor(String userId) throws ProfessorNotFoundException;

}
