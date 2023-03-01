/**
 * 
 */
package com.signify.bean;

import java.util.List;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class Student {

	private String studentName;
	private String address;
	private String userId;
	private String branchName;
	private boolean registered;
	private boolean paymentdone;
	private String Password;
	private String scholarshipId;
	private List<String> registeredCourses;
	private String batch;
	private boolean scholarship;
	private String phoneNumber;
	private boolean seeGrades;
	public String semester;
	
	
	/**@return the semester **/
	public String getsemester() {
		return semester;
	}
	/**
	 * 
	 * @param semester
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}	
	
	public boolean isSeeGrades() {
		return seeGrades;
	}
	/**
	 * 
	 * @param seeGrades
	 */
	public void setSeeGrades(boolean seeGrades) {
		this.seeGrades = seeGrades;
	}
	//To check the student has scholarship
	public boolean isScholarship() {
		return scholarship;
	}
	/**
	 * 
	 * @param scholarship
	 */
	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}
	/**@return the scholarshipID **/
	public String getScholarshipId() {
		return scholarshipId;
	}
	/**
	 * 
	 * @param scholarshipId
	 */
	public void setScholarshipId(String scholarshipId) {
		this.scholarshipId = scholarshipId;
	}	
	/**@return the phone number**/
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
	/**@return the password **/
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
	//method to check is registered or not	
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	/**@return the payment done **/
	public boolean isPaymentdone() {
		return paymentdone;
	}
	public void setPaymentdone(boolean paymentdone) {
		this.paymentdone = paymentdone;
	}
	/**@return the Student name **/
	public String getStudentName() {
		return studentName;
	}
	/**
	 * 
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	/**@return the address **/
	public String getAddress() {
		return address;
	}
	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
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
	/**@return the branch Name**/
	public String getBranchName() {
		return branchName;
	}
	
	/**
	 * 
	 * @param branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	//**@return the Registered Courses **/
	public List<String> getRegisteredCourses() {
		return registeredCourses;
	}
	/**
	 * 
	 * @param registeredCourses
	 */
	public void setRegisteredCourses(List<String> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	//**@return the batch **/
	public String getBatch() {
		return batch;
	}
	/**
	 * 
	 * @param batch
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}

}
