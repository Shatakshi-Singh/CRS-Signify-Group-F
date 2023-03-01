/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class GradeNotFoundException extends Exception{
	
//exception raise when professor tries to add grades which are not in the list
	public  GradeNotFoundException ()
	{
		//Message returned when exception is thrown
		super();
		 System.out.println("Grade Not Found ");
	}

}
