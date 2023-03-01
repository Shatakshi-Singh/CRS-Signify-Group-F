/**
 * 
 */
package com.signify.exception;

/**
 * @author GROUP H
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
		 * Message thrown by com.signify.exception
		 */
		System.out.println("Invalid UserID : " + userId);
	}
}
