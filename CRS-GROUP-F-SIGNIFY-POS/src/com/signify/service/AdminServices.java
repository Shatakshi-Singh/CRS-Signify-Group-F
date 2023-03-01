/**
 * 
 */
package com.signify.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @author BHAVISH
 *
 */
public  class AdminServices implements AdminInterface{
	
	ProfessorDAOInterface professorDataset = new ProfessorDAOImplementation();
	AdminDAOInterface adminDataset = new AdminDAOImplementation();
	UserDAOInterface userDataset = new UserDAOImplementation();
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	CatelogDAOInterface catelog = new CatelogDAOImplementation();
	//static int countProfessor = 0;
	public void assignCourse(String courseCode, String professorId) {
		try {
			
			if(isNumeric(professorId))
				if(professorDataset.getProfessor(professorId))
					catelog.add(professorId, courseCode);
				else 
					throw new ProfessorNotFoundException(professorId);
					
			else
				throw new UserNotFoundException(professorId);
			
		}catch(UserNotFoundException e) {
			
		}catch(ProfessorNotFoundException ex) {
			
		}catch(CourseNotFoundException ce) {
		}
	}
	
	
	public void addCourse(Course course) {
		try {
			courseDataset.add(course);
		} catch (CourseAlreadyRegisteredException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	public boolean addAdmin(Admin admin, User user) {
		
		int id = userDataset.add(user, 1);
		adminDataset.add(id,admin);
		return true;
			
	}
	
	
	public void dropCourse(String courseCode){
		try {
			courseDataset.remove(courseCode);
		}catch(CourseNotFoundException e) {
			
		}
	}
	
	
	public  void generateReportCard(){
		GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
		try {
			gradecard.generate();
		} catch (NoStudentsRegisteredForCourseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	public  void approveStudent(String userId){
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
			

		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	public  void addProfessor(String userId, Professor prof){
		
			User user = new User();

				user.setName(prof.getProfessorName());
				user.setRole("Professor");
				user.setPassword(prof.getPassword());
				int id = userDataset.add(user, 3);
				professorDataset.insert(id, prof);
			
		
	}
	
	
	public List<Course> courseDetails(){
		List<Course> courses = new ArrayList();
		try {

			System.out.println(" ===== VIEWING COURSE CATALOG ====== ");
			courses = courseDataset.view();
			System.out.println(" ====================================== ");
			
		}catch(NoCourseException e) {
			
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
		}
		
		return students;
		
	}
	
	
	@Override
	public void removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			if (isNumeric(admin.getAdminId())) {
				//adminDataset.remove(admin.getAdminId());
					userDataset.delete(admin.getAdminId());
				}
			else
				throw new AdminDoesntExistException();
			
		}catch(AdminDoesntExistException e) {
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
	public void approveAllStudents() {
		// TODO Auto-generated method stub
		try {
			userDataset.approveAll();
			studentDataset.approveAll();
		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}


	@Override
	public void removeProfessor(String userId) {
		// TODO Auto-generated method stub
		try {
			if(isNumeric(userId)) {
				professorDataset.delete(userId);
				userDataset.delete(userId);
			}
			else 
				throw new ProfessorNotFoundException(userId);
			
		}catch(ProfessorNotFoundException e) {
			
		}catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
			// throws invalid user exception 
		}
		return true;
	}
  }
