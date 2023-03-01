/**
 * 
 */
package com.signify.bean;

import java.beans.JavaBean;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author CRS_SIGNIFY_GROUP_H
 *
 */

@Component
public class SemesterRegistration {
	private int StudentId;
	private int semester;
	private Date dateofRegistration;
	
	/**@return the StudentID **/
	
	public int getStudentId() {
		return StudentId;
	}
	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	/**@return the semester**/
	
	public int getSemester() {
		return semester;
	}
	/**
	 * 
	 * @param semester
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	/**@return the Date of Registration **/
	
	public Date getDateofRegistration() {
		return dateofRegistration;
	}
	/**
	 * 
	 * @param dateofRegistration
	 */
	public void setDateofRegistration(Date dateofRegistration) {

		this.dateofRegistration = dateofRegistration;
	}
}
