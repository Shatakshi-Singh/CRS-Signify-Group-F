/**
 * 
 */
package com.signify.service;

import java.util.Date;

/**
 * @author GROUP H
 *
 */
public interface SemesterRegistrationInterface {
	/**
	 * 
	 * @param studentId
	 * @param Semester
	 * @param dateOfJoining
	 */
	public void registerCourses(String studentId, int Semester, Date dateOfJoining);
	/**
	 * 
	 * @param studentId
	 * @param Semester
	 * @param courseCode
	 * add course in the respective semester
	 */
	public void addCourse(String studentId, int Semester, String courseCode);
	/**
	 * To drop course
	 * @param studentId
	 * @param Semester
	 * @param courseCode
	 */
	public void dropCourse(String studentId, int Semester, String courseCode);
	/**
	 * To view course details
	 */
	public void viewCourseDetails();
	public void optCourse();
	public void registration();
	public void payfees();
	public void generateRegistionId();
	public void getSemesterDetails();
}
