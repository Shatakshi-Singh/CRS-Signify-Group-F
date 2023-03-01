/**
 * 
 */
package com.signify.service;

/**
 * @author BHAVISH
 *
 */
public interface PaymentInterface {
	//amount calculated
	public void calculateAmount();
	//payment made acknowledgment
	public void makePayment();
	//Returning status of the payment
	public boolean paymentStatus();
}
