package com.signify.exception;

public class InvalidPaymentDetails extends Exception{

	public InvalidPaymentDetails(String reason) {
		// TODO Auto-generated constructor stub
		System.out.println("Please enter valid details. You have entered "+reason);
	}

}
