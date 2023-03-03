package com.signify.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.signify.bean.Course;
import com.signify.bean.Payment;

//import java.util.Date;

import com.signify.bean.Student;
import com.signify.bean.User;

import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.dao.GradeCardDAOImplementation;
import com.signify.dao.GradeCardDAOInterface;
import com.signify.dao.PaymentDAOImplementation;
import com.signify.dao.PaymentDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;
import com.signify.exception.AddCourseStudentException;
import com.signify.exception.CourseAlreadyRegisteredException;
import com.signify.exception.CourseNotInRegisteredException;
import com.signify.exception.NoCourseException;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.PaymentDoneCourseNotAddedException;
import com.signify.exception.RegistrationFailedException;
import com.signify.validator.AddCourseByStudent;
import com.signify.validator.PaymentValidator;

@Service
public  class StudentServices implements StudentInterface { 
	Student student = new Student();
	StudentDAOInterface studentDataset = new StudentDAOImplementation(); 
	UserDAOInterface userDataset = new UserDAOImplementation();
	CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
    PaymentDAOInterface paymentDataset = new PaymentDAOImplementation();
    Payment payment = new Payment();
    
    
	public List<Course> viewGrades(String userId) {
		GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();

		List<Course> courses = new ArrayList<>();
		try {
			if(coursesDataset.countCourseStudent(userId)>=4)
				if(gradecard.view(userId))
					 courses = gradecard.viewgrades(userId);
				
		} catch (NoCourseRegisteredException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return courses;
	}
	public List<Course> viewCatelogs() {
		List<Course> courses = new ArrayList<>();
		try {
			courses = courseDataset.view();
		} catch (NoCourseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return courses;
	}
	public String addCourse(String userId,String course, int sem) {
		
		
			try {
					if(AddCourseByStudent.canAddCourse(userId)) 
						if(AddCourseByStudent.validCourse(course, sem))
						coursesDataset.addCourse(userId, course);
				
			} catch (CourseAlreadyRegisteredException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return "CourseAlreadyRegisteredException";
			} catch (PaymentDoneCourseNotAddedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return "PaymentDoneCourseNotAddedException";
			}catch(AddCourseStudentException e) {
				
				return "AddCourseStudentException";
				
			} catch (NoCourseRegisteredException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
				return "NoCourseRegisteredException";
			}
		
			return("Course Added");
	}
	public String dropCourse(String userId, String course) {
		
		try {
			coursesDataset.dropCourse(userId, course);
		} catch (CourseNotInRegisteredException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "NoCourseRegisteredException";
		} catch (PaymentDoneCourseNotAddedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "PaymentDoneCourseNotAddedException";
		}
		return "Course Dropped";
	}
	public void registerToCourse(String userId) {
		System.out.println("Registered. Proceed to payment to avail courses.");
	}
	public void editDetails(String userId, String field, String correction){
		
		
		Student student = new Student();
		 String query ="";
		//System.out.println(student.getStudentName());
		switch(field) {
		case "1":query = "name = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Name Updated.");
		break;
		case "2":query = "address = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Address Upadated.");
		break;
		case "3":query = "branchName = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Branch Updated.");
		break;
		case "4":query = "batch = \""+correction+"\" WHERE studentId = "+userId;
		studentDataset.update(query);
			System.out.println("Batch Updated.");
		break;
		case "5":query = "phone_number = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Phone Number Updated.");
		break;
		case "6":UserLoginServices.showMenu("Student", userId);
			//return;
		default : System.out.println("Enter valid numeric input.");
		}
		//StudentCollection.print();
		//System.out.println("student details edited");
	}
	public void makePayment(String userId, Payment payment) {
		// adding student to course if payment successful
		try {
				if(PaymentValidator.canMakePayment(userId))
			{
				studentDataset.registered(userId);
				GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
				gradecard.update(userId);
				String refId = UUID.randomUUID().toString();
				payment.setReferenceId(refId);
				paymentDataset.add(userId, payment);
				
				
			}
		}catch (RegistrationFailedException e) {
			
			
		} catch (NoCourseRegisteredException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	@Override
	public boolean addStudent(Student student) {

   		User user2 = new User();
			user2.setName(student.getStudentName());
			user2.setRole("Student");
			user2.setUserId(student.getUserId());
			user2.setPassword(student.getPassword());
		student.setPaymentdone(false);
		student.setRegistered(false);
		student.setScholarship(false);
		student.setSeeGrades(false);
		//System.out.println("Entered");
		int id = userDataset.add(user2, 4);
		//System.out.println("id =="+id);
		studentDataset.add(id, student);
		return true;
	}
	@Override
	public boolean validRegistration(Student student) {
		try {
			
			if(isNumeric(student.getsemester())){
				if(Integer.parseInt(student.getsemester())> 0) {
						if(Integer.parseInt(student.getsemester())< 9)
							return true;
						else
							throw new RegistrationFailedException("invalid entery in semester. Please register again.");
						}
				else
					throw new RegistrationFailedException("invalid entery in semester. Please register again.");
				
			}
			else
				throw new RegistrationFailedException("invalid entery in semester. Please register again.");
			
			
		}catch(RegistrationFailedException r) {
			
		}
		
		return false;
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
	@Override
	public List<Course> viewCourseForSem(String sem) {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		try {
				courses =  courseDataset.viewCoursesForSemester(Integer.parseInt(sem));
				
			} catch (NoCourseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return null;
			}
		return courses;
	}
	@Override
	public List<Course> viewAddedCoursesBtStudent(String userId) {
		List<Course> courses = new ArrayList<>();
		try {
				courses = coursesDataset.viewCourses(userId);
			} catch (NoCourseRegisteredException e) {
				// TODO Auto-generated catch block
				///e.printStackTrace();
				return null;
			}
		return courses;
			
	}
	@Override
	public String getSem(String id) {
		// TODO Auto-generated method stub
		return Integer.toString(studentDataset.getSem(id));
	}
	
}
