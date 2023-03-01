/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H 
 *
 */
public class PaymentDoneCourseNotAddedException extends Exception{

	/**
	 *  Message returned when com.signify.exception is thrown
	 */
	public PaymentDoneCourseNotAddedException() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("You have already registered for courses.");
	}

}
