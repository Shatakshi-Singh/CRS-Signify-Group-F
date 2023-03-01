/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class CourseNotAssignedToProfessorException extends Exception{

	/**
	 * 
	 */
	//Exception raise when course is not assigned to any professor
	public CourseNotAssignedToProfessorException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when exception is thrown
		 
		System.out.println("The course has not been assigned to any professor.");
	}

}
