/**
 * 
 */
package com.signify.service;

/**
 * @author BHAVISH
 *
 */
public class PaymentServices implements PaymentInterface {
	public void calculateAmount(){
		System.out.println("amot calculated");
	}
	public void makePayment(){
		System.out.println("payment made");
	}
	public boolean paymentStatus(){

		System.out.println("Returning status");
		boolean status = false;
		return status;
	}
	

}
