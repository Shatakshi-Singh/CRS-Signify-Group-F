/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class NoStudentsRegisteredForCourseException extends Exception{

	/**
	 * 
	 */
	public NoStudentsRegisteredForCourseException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when exception is thrown
		 
		System.out.println("There are no students who have registered for course");
	}

}
