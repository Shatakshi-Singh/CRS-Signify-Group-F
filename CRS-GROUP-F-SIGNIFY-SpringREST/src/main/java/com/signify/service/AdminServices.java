/**
 * 
 */
package com.signify.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.dao.CatelogDAOImplementation;
import com.signify.dao.CatelogDAOInterface;
import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.GradeCardDAOImplementation;
import com.signify.dao.GradeCardDAOInterface;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;
import com.signify.exception.*;

/**
 * @author GROUP H
 *
 */

@Service
public  class AdminServices implements AdminInterface{
	
	@Autowired
	User user;
	ProfessorDAOInterface professorDataset = new ProfessorDAOImplementation();
	AdminDAOInterface adminDataset = new AdminDAOImplementation();
	UserDAOInterface userDataset = new UserDAOImplementation();
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	CatelogDAOInterface catelog = new CatelogDAOImplementation();
	//static int countProfessor = 0;
	public String assignCourse(String courseCode, String professorId) {
		try {
			
			if(isNumeric(professorId))
				if(professorDataset.getProfessor(professorId)) {

					catelog.add(professorId, courseCode);
					return "Course Assigned.";
				}
				else 
					throw new ProfessorNotFoundException(professorId);
					
			else
				throw new UserNotFoundException(professorId);
			
		}catch(UserNotFoundException e) {
			
		}catch(ProfessorNotFoundException ex) {
			
			return "Professor Not found.";
			
		}catch(CourseNotFoundException ce) {
			
			return "Course Not found.";
		}
		
		return "Course could not be assigned.";
	}
	
	
	public boolean addCourse(Course course) {
		try {
			courseDataset.add(course);
			return true;
		} catch (CourseAlreadyRegisteredException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean addAdmin(Admin admin) {
		
		user.setRole("1");
		user.setName(admin.getAdminName());
		user.setPassword(admin.getPassword());

		int id = userDataset.add(user, 1);
		if(adminDataset.add(id,admin))
		return true;
		else
			return false;
			
	}
	
	
	public boolean dropCourse(String courseCode){
		try {
			courseDataset.remove(courseCode);
			return true;
		}catch(CourseNotFoundException e) {
			return false;
		}
	}
	
	
	public  boolean generateReportCard(){
		GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
		try {
			gradecard.generate();
			return true;
		} catch (NoStudentsRegisteredForCourseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}
	
	
	public List<Student> approveStudent(String userId){
		List<Student> students = new ArrayList<>();
		try {
			userDataset.getUnapproved();
		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			if(isNumeric(userId)) {
				if(userDataset.getRole(userId)==4) 
				{
					studentDataset.approve(userId);
					userDataset.updateStudent(Integer.parseInt(userId));
					}
				else
					throw new StudentNotFoundForApprovalException();}
			else 
				throw new UserNotFoundException(userId);
			
			
		}catch(UserNotFoundException e) {
			return null;

		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return students;
	}
	
	
	public void addProfessor(Professor prof){
		
				user.setName(prof.getProfessorName());
				user.setRole("Professor");
				user.setPassword(prof.getPassword());
				int id = userDataset.add(user, 3);
				professorDataset.insert(id, prof);
			
		
	}
	
	
	public List<Course> courseDetails(){
		List<Course> courses = new ArrayList();
		try {

			courses = courseDataset.view();
			
		}catch(NoCourseException e) {
			return null;
		}
		return courses;

	}
	
	
	@Override
	public List<Student> viewEnrolledStudents() {
		// TODO Auto-generated method stub

		List<Student> students = new ArrayList<>();
		try {
			students= studentDataset.view();
			
		} catch (NoApprovedStudentsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
		return students;
		
	}
	
	
	@Override
	public boolean removeAdmin(String id) {
		// TODO Auto-generated method stub
		try {
			if (isNumeric(id)) {
				//adminDataset.remove(admin.getAdminId());
					userDataset.delete(id);
					return true;
				}
			else
				throw new AdminDoesntExistException();
			
		}catch(AdminDoesntExistException e) {
			return false;
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public void editAdminDetails(Admin old, Admin admin) {
		// TODO Auto-generated method stub
		System.out.println("admin details will be edited here.");
	}
	
	
	@Override
	public void viewProfesssors() {
		// TODO Auto-generated method stub
		
		try {
			userDataset.printProfessors();
		} catch (NoProfessorInDatasetException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	
	@Override
	public List<Student> approveAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		try {
			userDataset.getUnapproved();
		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		try {
			userDataset.approveAll();
			studentDataset.approveAll();
		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return students;
		
	}


	@Override
	public boolean removeProfessor(String userId) {
		// TODO Auto-generated method stub
		try {
			if(isNumeric(userId)) {
				professorDataset.delete(userId);
				userDataset.delete(userId);
				return true;
			}
			else 
				throw new ProfessorNotFoundException(userId);
			
		}catch(ProfessorNotFoundException e) {
			return false;
			
		}catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			int a = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
			// throws invalid user com.signify.exception 
		}
		return true;
	}
  }
