/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H
 *
 */
public class ProfessorNotFoundException extends Exception{
	private String professorName ;
	   public ProfessorNotFoundException(String professorName)
	   {
		   super();
		  // Message returned when com.signify.exception is thrown
	       System.out.println("Professor Not Found : "+professorName);
	   }
}
