/**
 * 
 */
package com.signify.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;
import com.signify.exception.*;

/**
 * @author GROUP H
 *
 */

@Service
public class UserLoginServices implements UserLoginInterface {
	
	
	/*
	 * static CRSAdminMenu amenu = new CRSAdminMenu(); static CRSProfessorMenu pmenu
	 * = new CRSProfessorMenu(); static CRSStudentMenu smenu = new CRSStudentMenu();
	 */
	UserDAOInterface userDataset = new UserDAOImplementation();

	public static void showMenu(String role, String userId) {

			switch (role) {
			case "Student":
			//	smenu.display(userId);
				break;
			case "Professor":
				//pmenu.display(userId);
				break;
			case "Admin":
				//amenu.display();
				break;
			default:
				System.out.println("There was some error.");
			}
	}

	public String getDetails() {
		
		return "";

	}

	public String authenticate(User user) {
		if (isNumeric(user.getUserId())) {
			switch (userDataset.authenticate(user.getPassword(), user.getUserId())) {
			case 1:
				return "Admin";
			case 2:
				return "Student";
			case 3:
				return "Professor";
			case 4:
				return "unapproved";
			default:
				return "wrongPassword";
			}
		}
		return "Invalid";
	}

	public String login(User user) {

			try {
				switch (authenticate(user)) {
				case "Student":
					return("Login successful!  Student");
					//System.out.println("! Login successful! \n");
					//smenu.display(user.getUserId());
					//break;
				case "Professor":
					return("Login successful! Professor");
					//System.out.println("! Login successful! \n");
					//pmenu.display(user.getUserId());
					//break;
				case "Admin":
					return("Login successful!  Admin");
					//System.out.println("! Login successful! \n");
					//amenu.display();
					//break;
				case "unapproved":
					return("unapproved");
					//System.out.println(" Waiting for admin's approval.");
					//break;
				case "wrongPassword":
					return ("wrongPassword");
					//System.out.println(" Password Incorrect.");
					//break;
				default:
					//System.out.println("Invalid Details.");
					// UserNotFoundException ob = new UserNotFoundException(user.getUserId());
					
					throw new UserNotFoundException(user.getUserId());
				}
				
			}catch(UserNotFoundException e) {
				
			}
		// if false
		// print login invalid
		// direct back to main menu
			
			return("failed.");

	}

	public void logout(String userId, String password) {
		// direct to main menu
	}

	@Override
	public boolean updatePassword(String userId, String old, String password) {
		
			System.out.println("in login");
			// TODO Auto-generated method stub
			try {
				User user = new User();
				if(isNumeric(userId))
				{
				user.setUserId(userId);
				user.setPassword(old);
				String role = authenticate(user);
				if (role.equals("wrongPassword"))
					return false;
				
				else {

					userDataset.updatePassword(userId, password);
					return true;
				}
				}
				else

					 throw new UserNotFoundException(userId);
				
			}catch(UserNotFoundException e) {
				
			}
			return true;
	}

	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			int a = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
			// throws invalid user com.signify.exception
		}
		return true;
	}
}
