/**
 * 
 */
package com.signify.service;

/**
 * @author GROUP H
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
