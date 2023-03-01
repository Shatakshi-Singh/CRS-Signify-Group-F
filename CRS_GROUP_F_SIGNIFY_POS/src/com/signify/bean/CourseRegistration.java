/**
 * 
 */
package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class CourseRegistration {
	private String courseCode;
	private int semester;
	private int studentId;
	private String grade;
	
	
	/**@return the courseCode **/
	public String getCourseCode() {
		return courseCode;
	}
	
	/** @param coursecode the coursecode to set **/
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/**@return the semester **/
	public int getSemester() {
		return semester;
	}
	/** @param semester the semester to set **/
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	/**@return the studentID**/
	public int getStudentId() {
		return studentId;
	}
	
	/** @param studentID the studentID to set **/
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**@return the grade**/
	public String getGrade() {
		return grade;
	}
	
	/** @param grade the grade to set **/
	public void setGrade(String grade) {
		this.grade = grade;
}
}
