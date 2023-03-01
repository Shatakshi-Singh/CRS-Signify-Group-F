package com.signify.dao;

import java.util.List;

import com.signify.bean.Course;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.NoStudentsRegisteredForCourseException;

public interface GradeCardDAOInterface {
	
	/*
	  method to count the number of students that are assigned to a course
	  @param student    represents the student
	 */
	public void update(String userId);
	
	/*
	 method to view the grade
	 @param userId   unique id to represent the user
	 */
	public boolean view(String userId) throws NoCourseRegisteredException;
	
	/*
	 method to generate the grade
	 */
	public void generate() throws NoStudentsRegisteredForCourseException;
	
	/*
	 method to view the grades
	 @param userId   unique id to represent the user
	 @param cpi      represents grade point
	 */
	public List<Course> viewgrades(String userId);
	public double calculateCpi(List<Course>  courses);
}
