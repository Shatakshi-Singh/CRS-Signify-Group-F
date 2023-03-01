/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class NoCourseException extends Exception {

	/**
	 * 
	 */
	public NoCourseException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when exception is thrown
		 
		System.out.println("There are no courses available yet. ");
	}
	//Message returned when exception is thrown

}
