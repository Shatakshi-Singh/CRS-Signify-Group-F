/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class StudentNotApprovedException extends Exception{
	public  StudentNotApprovedException (String studentName)
	{
		super();
		/**
		 * Message returned when exception is thrown
		 */
		 System.out.println("Student Not Approved "+studentName);
	}
}
