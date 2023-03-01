package com.signify.dao;

import java.util.List;

import com.signify.bean.Course;
import com.signify.exception.CourseNotAssignedToProfessorException;
import com.signify.exception.CourseNotFoundException;

public interface CatelogDAOInterface {
	
    /*
	method to assign course to professor
	@param profid        unique id to identify professor
	@param courseCode    unique id to identify course
	*/ 
	public void add (String profid, String courseCode) throws CourseNotFoundException;
	
	/*
	method to remove the course from the database
	@param courseCode     unique id to identify course
	*/
	public void remove(String courseCode) throws CourseNotFoundException;
	/*
	method to get the course form catalog
	@param prof    professor
	@return List of courses
	 */
	public List<Course> getCourse(String prof) throws  CourseNotAssignedToProfessorException;
}
