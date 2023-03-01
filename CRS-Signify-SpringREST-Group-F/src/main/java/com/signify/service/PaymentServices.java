/**
 * 
 */
package com.signify.service;

import org.springframework.stereotype.Service;

/**
 * @author GROUP H
 *
 */

@Service
public class PaymentServices implements PaymentInterface {
	public void calculateAmount(){
		System.out.println("amount calculated");
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
