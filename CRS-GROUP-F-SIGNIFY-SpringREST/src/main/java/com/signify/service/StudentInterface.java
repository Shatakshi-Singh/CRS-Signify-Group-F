/**
 * 
 */
package com.signify.service;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.bean.User;

/**
 * @author GROUP H
 *
 */
public interface StudentInterface {
	/**
	 * to add student as the user
	 * @param student
	 * @param user
	 * @return
	 */
	public boolean addStudent(Student student);
	/**
	 * to view grades by the students
	 * @param userid
	 * @return 
	 */
	public List<Course> viewGrades(String userid) ;
	public List<Course> viewCatelogs();
	
	public List<Course> viewCourseForSem(String sem);
	
	public List<Course> viewAddedCoursesBtStudent(String id);
	/**
	 * To add course by the student
	 * @param userId
	 * @param course
	 * @param sem
	 */
	public String addCourse(String userId, String course, int sem);
	/**
	 * drop the selected the course
	 * @param userId
	 * @param course
	 */
	public String dropCourse(String userId, String course);
	/**
	 * 
	 * @param userId
	 */
	public void registerToCourse(String userId);
	/**
	 * to edit student details
	 * @param userId
	 * @param field
	 * @param correction
	 */
	public void editDetails(String userId, String field, String correction);
	/**To edit student details
	 * 
	 * @param userId
	 * @param payment
	 */
	public void makePayment(String userId, Payment payment);
	/**
	 * 
	 * @param student
	 * @return
	 */
	public boolean validRegistration(Student student);
	
	public String getSem(String id);

}
