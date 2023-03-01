/**
 * 
 */
package com.signify.constants;

/**
 * @author GROUP-E-CRS-SIGNIFY
 *
 */
public class SQLConstants {
	/** 
			Constants of the Students 
	*/
	// STUDENT Constnats Queries 
	public static final String REGISTER_STUDENT="insert into students values(?,?,?,?,?,?,?,?,?)";
	public static final String VIEW_ENROLLED_STUDENTS = "SELECT studentId, studentName, branchName FROM students WHERE approved = 1";
	public static final String UPDATE_ALL_STUDENTS = "UPDATE students SET approved = 1";
	public static final String UPDATE_STUDENT = "update students set approved = 1 where studentId = ";
	public static final String UPDATE_STUDENT_DETAILS = "update students set ";
	public static final String DELETE_STUDENT = "delete from students where studentId =  ";
	public static final String REGISTRATION_AFTER_PAYMENT = "UPDATE students SET registered = 1 where studentId = ";
	public static final String GET_SEMESTER = "select semester from students where studentId =";
	//Admin
	/**
		Constants of the Admin
	
	**/
	public static final String ADD_ADMIN = "insert into admins values(?,?)";
	public static final String DELETE_ADMIN = "delete from admins where userid=";
	
	// Catelog Exception
	/**
	  Constants of Catalog
	
	**/
	
	public static final String ADD_CP_IN_CATELOG = "insert into catalog(course, professor) values(?,?)";
	public static final String DELETE_CP_IN_CATELOG = "delete from catalog where course=";
	public static final String GET_COURSE = "select course from catalog where professor =";
	
	//Course Queries
	/**
		Constants of Course
	
	
	**/
	public static final String ADD_COURSE ="insert into course values(?,?,?,?)";
	public static final String DELETE_COURSE = "delete from course where courseCode= ?";
	public static final String VIEW_COURSES = "SELECT * FROM course";
	public static final String VIEW_COURSES_FOR_SEM = "SELECT * FROM course where semester = ";
	/**
		Constants of course registration
	
	**/
	//course registration queries
	public static final String ADD_REGISTERED_COURSE = "insert into course_registration(studentId, courseCode) values(?,?)";
	public static final String DELETE_REGISTERED_COURSE =  "delete from course_registration where courseCode= ? and studentId = ?";
	/**
	  Constants for Gradescard
	
	**/
	//Gradescard queries
	public static final String GENERATE_REPORT_CARD = "update gradescard set visible = 1";
	public static final String VIEW_REPORT_CARD = "select cpi,visible from gradescard where student = ";
	public static final String UPDATE_GRADE_CARD = "insert into gradescard values(?,?,?)";
	/**
	Constants for payment
	**/
	//payment queries
	public static final String ADD_PAYMENT = "insert into payments values(?,?,?,?,?,?,?,?)";
	public static final String GET_PAMENT = "select * from payments where student = ";
	/**
	Constants for Professors
	**/
	// Professors Queries 
	public static final String ADD_PROFESSOR = "insert into professors values(?,?,?,?,?)"; 
	public static final String DELETE_PROFESSOR = "delete from professors where profId = ?";
	/**
	Constants for User
	**/
	//User queries
	public static final String ADD_USER = "insert into users(name, password, role_id) values(?,?,?)";
	public static final String PRINT_PROFESSORS = "SELECT userId, name FROM users WHERE role_id = 3";
	public static final String APPROVE_ALL_STUDENTS = "UPDATE users set role_id = 2 where userId = (SELECT studentId FROM students WHERE approved = 0)";
	public static final String GET_UNAPPROVED_STUDENTS = "SELECT name, userId FROM users WHERE role_id = 4";
	public static final String DELETE_USER = "delete from users where userId = ?";
}
