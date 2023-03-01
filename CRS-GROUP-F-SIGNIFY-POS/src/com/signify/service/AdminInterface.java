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
 * @author BHAVISH
 *
 */
public interface AdminInterface {
	
	public void assignCourse(String courseCode, String professorId);
	/**
     * method for adding course into the catalog
     *
     * @param course	Course object containing details of the course
     * @return returns status of addCourse operation as a string
     */
	public void addCourse(Course course);
	/**
     * method for removing course from the catalog
     *
     * @param  course to represent a course
     * @throws throws CourseNotFoundException if the course is not present in the catalog
     */
	public void dropCourse(String courseCode);
	/* method for generating grade card and calculating aggregate CGPA of student
    *
    */
	public void generateReportCard();
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
	
	public boolean addAdmin(Admin admin, User user);
	/**
     * method for removing admin 
     *
     * @param  admin represent admin
     * @throws throws AdminDoesntExistException if the admin is not present in the catalog
     */
	public void removeAdmin(Admin admin);
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
	public void addProfessor(String userId, Professor professor);
	/**
     * method for adding professor from the catalog
     *
     * @param  userId ,professor
     * @throws throws ProfessorNotFoundException if the course is not present in the catalog
     */
	public void viewProfesssors();
	//throws NoProfessorInDatasetException
	public void removeProfessor(String userId);
	//@param userId
	//throws NoProfessorInDatasetException
	public void approveStudent(String userId);
	//@param userId
	//throws StudentNotFoundForApprovalException
	public List<Student> viewEnrolledStudents();
	//throws NoApprovedStudentsException
	public void approveAllStudents();
	//throws NoApprovedStudentsException
	
	public boolean isNumeric(String strNum) ;
	// throws invalid user exception i.e NumberFormatException

}
