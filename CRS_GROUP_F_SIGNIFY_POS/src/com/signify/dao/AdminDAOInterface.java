/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Admin;
import com.signify.exception.AdminDoesntExistException;

/**
 * @author BHAVISH
 *
 */
public interface AdminDAOInterface {
	
	
	
	public void update(String query);
	
	/*
	 method for adding admin into database
	 @param id unique id to represent the admin 
	 */
	
	public void add(int id, Admin admin);
	
	/*
	 method for removing the admin
	@param adminId unique id to represent the admin
	*/
	
	public void remove(String adminId) throws AdminDoesntExistException;
	
	public void view(String query);

}
