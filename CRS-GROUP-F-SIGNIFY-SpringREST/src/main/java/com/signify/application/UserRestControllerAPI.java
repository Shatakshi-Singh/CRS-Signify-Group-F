/**
 * 
 */
package com.signify.application;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.User;
import com.signify.service.UserLoginInterface;


/**
 * @author WELCOME
 *
 */

@RestController
public class UserRestControllerAPI {

	@Autowired
	private UserLoginInterface userServices;
	@Autowired
	private User user;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getUser(@RequestBody Map<String, String> param) {

		user.setUserId((param.get("id")));
		user.setPassword(param.get("password"));
		String response = userServices.login(user);
		
	return new ResponseEntity<String>(response , HttpStatus.OK);
//		if (response.equals("wrongPassword")) {
//			return new ResponseEntity<String>("No User found for ID " + param.get("id"), HttpStatus.NOT_FOUND);
//		}
//		else if(response.equals("unapproved"))
//			return new ResponseEntity<String>(response, HttpStatus.NOT_ACCEPTABLE);
//
//		return new ResponseEntity<String>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@RequestMapping(value = "/updatePassword/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody Map<String, String> param) {

		String oldPassword = param.get("oldPassword");
		String newPassword = param.get("newPassword");
		if (userServices.updatePassword(id, oldPassword, newPassword)) {
			return new ResponseEntity<String>("Password Updated",HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
	}
}
