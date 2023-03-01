/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class CourseNotFoundException extends Exception {

	public CourseNotFoundException (String courseCode)
	{
		super();
		//Exception raise when user enters wrong coursecode
		 System.out.println("Invalid CourseCode "+courseCode);
	}
	//Message returned when exception is thrown
	 
}
