package com.signify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.exception.InvalidEntryException;
import com.signify.exception.NoApprovedStudentsException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.UserNotFoundException;
import com.signify.validator.GradeChecker;


@Service
public class ProfessorService implements ProfessorInterface {
	
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	ProfessorDAOInterface professordataset = new ProfessorDAOImplementation();
	CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	
	public void changeGrade(String studentId, String grade, String courseCode) {
		try {
			if(GradeChecker.isValidGrade(grade))
				if(coursesDataset.getStudent(studentId, courseCode))
			coursesDataset.addGrade(studentId, courseCode, grade);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	public void viewEnrolledStudents(String code) {
		try {
				coursesDataset.viewStudents(code);
			
		}catch (NoStudentsRegisteredForCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectCourse() {
		/*Scanner in = new Scanner (System.in);
		System.out.println("Enter Name : ");
		String name = in.next();
        System.out.println("Enter Semester : ");
        int sem = in.nextInt();
        System.out.println("Enter course code : ");
        String code = in.next();
        Course course = new Course();
        course.setProfessorName(name);
        course.setCourseCode(code);
        course.setSemester(sem);
        //course catalog to add professor
        in.close();*/
		
		System.out.println("selecting course") ;
	}
	public void editDetails(String userId, String field, String correction) throws InvalidEntryException {
		///to be approved by admin
		
		if(field == "5")
			UserLoginServices.showMenu("Proffessor", userId);
		else if(field =="4" || field =="3"|| field =="2" || field =="1")
			try {
				professordataset.update(correction, userId, field);
			} catch (ProfessorNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		else
			throw new InvalidEntryException();
		
		
		//System.out.println("editing Details");
	}
	public void viewDetails() {
		System.out.println("viewing details");
	}
	
}
