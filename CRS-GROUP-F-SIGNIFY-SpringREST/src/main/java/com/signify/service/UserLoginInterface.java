/**
 * 
 */
package com.signify.service;

import com.signify.bean.User;

/**
 * @author GROUP H
 *
 */
public interface UserLoginInterface {
	
/**
 * 
 * @param role
 * @param userId
 */

	public static void showMenu(String role, String userId) {
	}
	/**
	 * user login
	 * @param user
	 */
	public String login(User user);
	/**
	 * user logout
	 * @param userId
	 * @param password
	 */
	public void logout(String userId, String password);
	public String getDetails();
	/**
	 * to update user password
	 * @param userId
	 * @param old
	 * @param password
	 */
	public boolean updatePassword(String userId, String old, String password);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isNumeric(String userId);
	//throws com.signify.exception NumberFormatException
}
