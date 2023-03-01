/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class RegistrationFailedException extends Exception{

	/**
	 *  Message returned when exception is thrown
	 */
	public RegistrationFailedException(String message) {
		// TODO Auto-generated constructor stub
		System.out.println("Registration failed due to "+message);
	}

}
