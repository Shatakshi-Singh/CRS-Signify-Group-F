/**
 * 
 */
package com.signify.bean;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;

/**
 * @author CRS_SIGNIFY_GROUP_H
 *
 */

@Component
public class PaymentNotification {
	private int notificationId;
	private String notificationMessage;
	private int referenceId;
	
	/**@return the NotificationID **/

	public int getNotificationId() {
		return notificationId;
	}
	/**
	 * 
	 * @param notificationId
	 */
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	/**@return the referenceID**/
	public int getReferenceId() {
		return referenceId;
	}
	
	/**
	 * 
	 * @param referenceId
	 */
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	
	/**@return the Notification Message **/
	public String getNotificationMessage() {
		return notificationMessage;
	}
	/**
	 * 
	 * @param notificationMessage
	 */
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
}
