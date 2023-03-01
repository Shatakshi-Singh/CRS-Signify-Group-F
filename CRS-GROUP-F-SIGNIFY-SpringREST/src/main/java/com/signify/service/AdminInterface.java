/**
 * 
 */
package com.signify.service;

import java.util.List;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.exception.StudentNotFoundForApprovalException;

/**
 * @author GROUP H
 *
 */
public interface AdminInterface {
	
	public String assignCourse(String courseCode, String professorId);
	/**
     * method for adding course into the catalog
     *
     * @param course	Course object containing details of the course
     * @return returns status of addCourse operation as a string
     */
	public boolean addCourse(Course course);
	/**
     * method for removing course from the catalog
     *
     * @param  course to represent a course
     * @throws throws CourseNotFoundException if the course is not present in the catalog
     */
	public boolean dropCourse(String courseCode);
	/* method for generating grade card and calculating aggregate CGPA of student
    *
    */
	public boolean generateReportCard();
	/**
     * method for viewing all courses in the catalog
     *
     * @return returns List of all courses from the catalog
     */
	
	public List<Course> courseDetails();
	/**
     * method for adding other admin into the catalog
     *
     * @param admin,user
     * @return returns status of addadmin operation
     */
	
	public boolean addAdmin(Admin admin);
	/**
     * method for removing admin 
     *
     * @param  admin represent admin
     * @throws throws AdminDoesntExistException if the admin is not present in the catalog
     */
	public boolean removeAdmin(String id);
	/**
     * method for updating admin
     *
     * @param  old,admin
     * 
     */
	
	public void editAdminDetails(Admin old, Admin admin);
	/**
     * method for adding professor 
     *
     * @param course	Course object containing details of the course
     * @return returns status of addCourse operation as a string
     */
	public void addProfessor(Professor professor);
	/**
     * method for adding professor from the catalog
     *
     * @param  userId ,professor
     * @throws throws ProfessorNotFoundException if the course is not present in the catalog
     */
	public void viewProfesssors();
	//throws NoProfessorInDatasetException
	public boolean removeProfessor(String userId);
	//@param userId
	//throws NoProfessorInDatasetException
	public List<Student> approveStudent(String userId);
	//@param userId
	//throws StudentNotFoundForApprovalException
	public List<Student> viewEnrolledStudents();
	//throws NoApprovedStudentsException
	public List<Student> approveAllStudents();
	//throws NoApprovedStudentsException
	
	public boolean isNumeric(String strNum) ;
	// throws invalid user com.signify.exception i.e NumberFormatException

}
