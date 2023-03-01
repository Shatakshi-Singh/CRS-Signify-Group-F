/**
 * 
 */
package com.signify.dao;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotInRegisteredException;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.exception.PaymentDoneCourseNotAddedException;
import com.signify.exception.UserNotFoundException;

/**
 * @author GROUP H
 *
 */
public interface CourseRegistrationDAOInterface {
	
	/*
	  method to add course
	  @param course     represents the course
	  @param student    represents the student
	 */
	public void addCourse(String student, String course) throws CourseAlreadyRegisteredException, PaymentDoneCourseNotAddedException;
	
	/*
	  method to drop course
	  @param course     represents the course
	  @param student    represents the student
	 */
	public void dropCourse(String student, String course) throws CourseNotInRegisteredException, PaymentDoneCourseNotAddedException;
	
	/*
	  method to view courses
	  @param student    represents the student
	 */
	public List<Course> viewCourses(String Student) throws NoCourseRegisteredException;
	
	/*
	  method to view courses
	  @param course     represents the course
	 */
	public List<Student> viewStudents(String course) throws NoStudentsRegisteredForCourseException;
	
	/*
	  method to add the grade
	  @param course     represents the course
	  @param student    represents the student
	  @param grade      represents the grade
	 */
	public void addGrade(String student, String course, String grade) throws UserNotFoundException;
	
	/*
	  method to get the payment status
	  @param studentId unique id to represent the student
	 */
	public boolean getPaymentstatus(String studentId);
	
	/*
	  method to count the number of students that are assigned to a course
	  @param student    represents the student
	 */
	public int countCourseStudent(String student);
	
	/*
	  method to check if the course is available for the semester or not
	  @param code   represents the course code
	  @param  sem   represents
	 */ 
	public boolean courseAvailableForSemester(String code, int sem);
	
	public boolean getStudent(String userId, String course)throws UserNotFoundException;
}
