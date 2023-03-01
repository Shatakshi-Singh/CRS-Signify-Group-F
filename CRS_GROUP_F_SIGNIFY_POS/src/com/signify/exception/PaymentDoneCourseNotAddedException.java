/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class PaymentDoneCourseNotAddedException extends Exception{

	/**
	 *  Message returned when exception is thrown
	 */
	public PaymentDoneCourseNotAddedException() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("You have already registered for courses.");
	}

}
