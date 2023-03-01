/**
 * 
 */
package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
//Declaration of Professor bean
public class Professor {
	private String designation;
	private String professorName;
	private String userId;
	private String departmentName;
	private String Password;
	private String phoneNumber;
	private String assignedCourse;


	/**@return the assigned Course **/
	public String getAssignedCourse() {
		return assignedCourse;
	}
	/**
	 * 
	 * @param assignedCourse
	 */
	public void setAssignedCourse(String assignedCourse) {
		this.assignedCourse = assignedCourse;
	}
	/**@return the Phone Number **/
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**@return the password**/
	public String getPassword() {
		return Password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	/**@return the department Name **/
	
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * 
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**@return the designation**/
	
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * 
	 * @param designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**@return the professor Name**/
	public String getProfessorName() {
		return professorName;
	}
	/**
	 * 
	 * @param professorName
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	/**@return the userID **/
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
	

}
