/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H
 *
 */
public class NoCourseRegisteredException extends Exception{

	/**
	 * 
	 */
	public NoCourseRegisteredException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when com.signify.exception is thrown
		 
		System.out.println("No courses have been added by you.");
	}

}
