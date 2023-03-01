/**
 * 
 */
package com.signify.service;

/**
 * @author BHAVISH
 *
 */
public interface PaymentNotificationInterface {

	//notification id generated
	public void generateNotificationId() ;
	//This will give the notif message
	public void notificationMessage();
	public void makeNotification();

}
