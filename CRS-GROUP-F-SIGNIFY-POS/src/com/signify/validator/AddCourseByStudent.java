/**
 * 
 */
package com.signify.validator;

import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.exception.AddCourseStudentException;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.NoCourseRegisteredException;

/**
 * @author GROUP-E-CRS-SIGNIFY
 *
 */
public class AddCourseByStudent {
	static CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	/***
		Method to Add Course and throws exception if something went wrong 
		@return Exception occurred
		@params String userId to accept the id to make change
	
	**/
	public static boolean canAddCourse(String userId) throws AddCourseStudentException, NoCourseRegisteredException{
		int courses = coursesDataset.countCourseStudent(userId);
		if(courses <4) 
		return true;
		else if(courses >=4 && courses<6) {
			System.out.println("You already have registered 4 primary courses. This will be your secondary courses.");
			return true;
		}
		else {
			throw new AddCourseStudentException("You have already registered for courses. Proceed to make fee payment.");
			
		}
			
	}
	/**
		Method to Check Availability of the course 
		@return if Exception occurred
		@params String code take the code of course
		int sem it take the sem you are in 
	
	**/
	
	public static boolean validCourse(String code, int sem) throws AddCourseStudentException {
		
		if(coursesDataset.courseAvailableForSemester(code, sem))
			return true;
		else
			throw new AddCourseStudentException("You have entered invalid course code.");
		
	}
}
