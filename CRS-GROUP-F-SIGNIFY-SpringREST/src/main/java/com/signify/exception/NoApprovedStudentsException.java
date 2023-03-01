/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H
 *
 */
public class NoApprovedStudentsException extends Exception {

	/**
	 * 
	 */
	//Exception raise when no students are approved by admin
	public NoApprovedStudentsException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when com.signify.exception is thrown
		 
		System.out.println("There are no approved students yet.");
	}

}
