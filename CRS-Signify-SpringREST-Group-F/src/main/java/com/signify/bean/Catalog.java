/**
 * 
 */
package com.signify.bean;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author CRS_SIGNIFY_GROUP_H
 *
 */

@Component
public class Catalog {
	private int totalCourses;
	private int totalDepartments;
	private String department;
	private List<String> courseCodes;
	private String proffesor;
	
	
	/**@return the Total course **/
	
	public int getTotalCourses() {
		return totalCourses;
	}
	
	/** @param Total course the Total course to set **/
	
	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}
	
	/**@return the Total Departments **/

	public int getTotalDepartments() {
		return totalDepartments;
	}
	
	/** @param Total departments the Total departments to set **/
	
	public void setTotalDepartments(int totalDepartments) {
		this.totalDepartments = totalDepartments;
	}
	
	/**@return the department **/
	
	public String getDepartment() {
		return department;
	}
	/** @param department the department to set **/
	
	public void setDepartment(String department) {
		this.department = department;
	}
	/**@return the course code **/
	public List<String> getCourseCodes() {
		return courseCodes;
	}
	/** @param course code the course code to set **/
	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}
	/**@return the professor **/
	public String getProffesor() {
		return proffesor;
	}
	/** @param professor the professor to set **/
	public void setProffesor(String proffesor) {
		this.proffesor = proffesor;
	}

}
