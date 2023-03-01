/**
 * 
 */
package com.signify.bean;

import java.beans.JavaBean;
//import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author CRS_SIGNIFY_GROUP_H
 *
 */

@Component
public class GradeCard {
	
	private int studentId;
	private int semester;
	private float cpi;
	private Map<String,String> grades;
	private enum grade {A,B,C,D};
	public int getStudentId() {
		return studentId;
	}
	
	/**@return the StudentID **/
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**@return the semester **/
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
	/**@return the CPI **/
	public float getCpi() {
		return cpi;
	}
	
	/**
	 * 
	 * @param cpi
	 */
	public void setCpi(float cpi) {
		this.cpi = cpi;
	}
	
	/**@return the grades **/
	public Map<String, String> getGrades() {
		return grades;
	}
	/**
	 * 
	 * @param grades
	 */
	public void setGrades(Map<String, String> grades) {
		this.grades = grades;
	}
	

}
