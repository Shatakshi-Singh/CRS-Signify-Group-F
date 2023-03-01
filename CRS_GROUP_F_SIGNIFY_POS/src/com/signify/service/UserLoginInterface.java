/**
 * 
 */
package com.signify.service;

import com.signify.bean.User;

/**
 * @author BHAVISH
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
	public void login(User user);
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
	public void updatePassword(String userId, String old, String password);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isNumeric(String userId);
	//throws exception NumberFormatException
}
