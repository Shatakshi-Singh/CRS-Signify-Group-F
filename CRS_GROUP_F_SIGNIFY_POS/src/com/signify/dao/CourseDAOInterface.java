/**
 * 
 */
package com.signify.dao;

import java.util.List;

import com.signify.bean.Course;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;

/**
 * @author GROUP-E-CRS-SIGNIFY
 *
 */
public interface CourseDAOInterface {
	
	/*
	 method to add course
	 @param course     object of class Course 
	 */
	public void add(Course course) throws CourseAlreadyRegisteredException;
	
	/*
	  method to remove course
	  @param courseCode     unique id to identify course
	 */
	public void remove(String courseCode) throws CourseNotFoundException;
	
	/*
	  method to uodate course
	  @param query    sql query to update in the database
	 */
	public void update(String query);
	
	/*
	  method to view course
	 */
	public List<Course> view() throws NoCourseException;
	
	/*
	  method to view courses for the semester
	  @param sem     represents the sem
	 */
	public List<Course> viewCoursesForSemester(int sem) throws NoCourseException;
	

}
