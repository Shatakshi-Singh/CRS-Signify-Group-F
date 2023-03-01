package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class User {
	private String userId;
	private String name;
	private String role;
	private String password;
	
	//**@return the password **/
	
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	//**@return the userID **/
	
	public String getUserId() {
		return userId;
	}
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//**@return the name **/
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	//**@return the role**/
	public String getRole() {
		return role;
	}
	/**
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
