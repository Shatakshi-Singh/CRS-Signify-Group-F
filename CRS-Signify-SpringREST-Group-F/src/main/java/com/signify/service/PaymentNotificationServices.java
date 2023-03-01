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
public class PaymentNotificationServices implements PaymentNotificationInterface{
	
	public void generateNotificationId() {
		System.out.println("notification id generated");
	}
	public void notificationMessage() {
		System.out.println("notification message");
	}
	public void makeNotification(){
		System.out.println("make notification function");
	}

}
