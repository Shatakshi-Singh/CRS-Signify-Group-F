/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H
 *
 */
public class CourseAlreadyRegisteredException extends Exception{

	/**
	 * 
	 */
	//com.signify.exception raise when student register for two same courses
	public CourseAlreadyRegisteredException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when com.signify.exception is thrown
		 
		System.out.println("This course has already been added.");
	}

}
