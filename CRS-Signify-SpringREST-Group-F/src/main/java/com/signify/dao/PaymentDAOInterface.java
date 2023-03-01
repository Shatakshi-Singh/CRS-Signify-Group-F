/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Payment;

/**
 * @author GROUP H 
 *
 */
public interface PaymentDAOInterface {
	
	/*
	 method to add payment method
	 @param userId   unique id to represent the user
	 @param payment  payment object of Payment class
	 */
	public void add(String userId, Payment payment);
	public Payment getAmount(String userId);
}
