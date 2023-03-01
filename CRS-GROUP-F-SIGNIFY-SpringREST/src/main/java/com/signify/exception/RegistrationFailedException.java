/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H
 *
 */
public class RegistrationFailedException extends Exception{

	/**
	 *  Message returned when com.signify.exception is thrown
	 */
	public RegistrationFailedException(String message) {
		// TODO Auto-generated constructor stub
		System.out.println("Registration failed due to "+message);
	}

}
