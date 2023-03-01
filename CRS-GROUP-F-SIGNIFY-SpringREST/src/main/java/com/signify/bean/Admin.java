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
public class Admin {
	
	private String adminName;
	private String adminId;
	private String Password;
	
	/** @return admin name**/
	public String getAdminName() {
		return adminName;
	}
	/**@param admin name the admin name to set**/
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	/** @return admin ID**/
	public String getAdminId() {
		return adminId;
	}
	/**@param admin ID the admin ID to set**/
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/** @return password**/
	public String getPassword() {
		return Password;
	}
	/**@param password the password to set**/
	public void setPassword(String password) {
		Password = password;
	}
}

