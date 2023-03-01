/**
 * 
 */
package com.signify.service;

import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.bean.User;

/**
 * @author BHAVISH
 *
 */
public interface StudentInterface {
	/**
	 * to add student as the user
	 * @param student
	 * @param user
	 * @return
	 */
	public boolean addStudent(Student student, User user);
	/**
	 * to view grades by the students
	 * @param userid
	 * @return 
	 */
	public boolean viewGrades(String userid) ;
	public void viewCatelogs();
	/**
	 * To add course by the student
	 * @param userId
	 * @param course
	 * @param sem
	 */
	public void addCourse(String userId, String course, int sem);
	/**
	 * drop the selected the course
	 * @param userId
	 * @param course
	 */
	public void dropCourse(String userId, String course);
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

}
