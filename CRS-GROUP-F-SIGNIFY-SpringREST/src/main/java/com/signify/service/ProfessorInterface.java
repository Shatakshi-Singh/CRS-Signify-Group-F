/**
 * 
 */
package com.signify.service;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.exception.InvalidEntryException;

public interface ProfessorInterface {
	/**
	 * 
	 * @param studentId
	 * @param grade
	 * @param courseCode
	 * to change grades of the student
	 * @return 
	 */
	public boolean changeGrade(String studentId, String grade, String courseCode);
	/**
	 * 
	 * @param code
	 * to view all the enrolled students
	 * @return 
	 */
	public List<Student> viewEnrolledStudents(String code);
	/**
	 * Selecting course by the professor
	 */
	public List<Course> selectCourse(String userId) ;
	/**
	 * 
	 * @param userId
	 * @param field
	 * @param correction
	 * @throws InvalidEntryException 
	 */
	public void editDetails(String userId, String field, String correction) throws InvalidEntryException;
	public void viewDetails();
}
