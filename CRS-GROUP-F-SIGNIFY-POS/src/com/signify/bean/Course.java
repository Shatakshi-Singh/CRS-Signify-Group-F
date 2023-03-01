package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
import java.util.List;

public class Course {
	private String courseName;
	private String courseCode;
	private String departmentName;
	private String professorName;
	private boolean isOffered;
	private String semester;
	private List<String> enrolledStudents;
	private int enrolledStudentCount;
	private String grade;
	
	/**
	 * @param courseId
	 * @param courseName
	 * @param departmentName
	 * @param professorId
	 * @param studentCount
	 */
	/*public Course (String courseCode, String courseName, String departmentName, String semester) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.departmentName = departmentName;
		this.semester = semester;
				
	}*/
	
	/**@return the semester **/
	public String getSemester() {
		return semester;
	}
	
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	/**@return the CourseName  **/
	public String getCourseName() {
		return courseName;
	}
	
	//method to set courseName
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	//method to get courseCode
	public String getCourseCode() {
		return courseCode;
	}
	/**@return the CourseName  **/
	public void setCourseCode(String courseId) {
		this.courseCode = courseId;
	}
	//method to get Department Name
	public String getDepartmentName() {
		return departmentName;
	}
	
	/**@return the DepartmentName  **/
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	//method to get ProfessorName
	public String getProfessorName() {
		return professorName;
	}
	
	/**@return the professorName  **/
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	//method to get Enrolled Students
	public List<String> getEnrolledStudents() {
		return enrolledStudents;
	}
	
	/**@return the enrolledStudents  **/
	public void setEnrolledStudents(List<String> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	//method to get Enrolled Students Count
	public int getEnrolledStudentCount() {
		return enrolledStudentCount;
	}
	
	/**@return the enrolled student count  **/
	public void setEnrolledStudentCount(int enrolledStudentCount) {
		this.enrolledStudentCount = enrolledStudentCount;
	}
	public boolean isOffered() {
		return isOffered;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
