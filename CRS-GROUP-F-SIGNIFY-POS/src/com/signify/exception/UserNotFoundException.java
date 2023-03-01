/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class UserNotFoundException extends Exception {
	private String userName;

	public UserNotFoundException(String userId) {
		super(userId);
		/***
		 * constructor
		 * @param userId
		 */
		this.userName = userId;
		/**
		 * Message thrown by exception
		 */
		System.out.println("Invalid UserID : " + userId);
	}
}
