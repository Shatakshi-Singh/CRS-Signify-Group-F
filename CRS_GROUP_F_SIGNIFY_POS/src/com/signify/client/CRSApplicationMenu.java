/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.exception.InvalidEntryException;
import com.signify.exception.NoCourseException;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServices;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorService;
import com.signify.service.SemesterRegistrationInterface;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentInterface;
import com.signify.service.StudentServices;
import com.signify.service.UserLoginInterface;
import com.signify.service.UserLoginServices;


/**
 * @author CRS_GROUP_E_SIGNIFY
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
	
        System.out.println("\t WELCOME TO CRS APPLICATION");
        
        
        //Object DeclarATION
        Scanner in = new Scanner (System.in);
        //Student student = new Student();
        Professor professor = new Professor();
        Admin admin = new Admin();
        User user = new User();
        StudentInterface studentServices = new StudentServices();
        ProfessorInterface professorServices = new ProfessorService();
        AdminInterface adminServices = new AdminServices();
        UserLoginInterface userLoginService = new UserLoginServices();
        SemesterRegistrationInterface register = new SemesterRegistrationServices();  
    	CRSStudentMenu smenu = new CRSStudentMenu();
    	
    	
    	//StudentCollection studentDataset = new StudentCollection();
      
        
        boolean exit = true;
    	   while(exit) {
    	        System.out.println("------------------------------------------------------");  
    	        System.out.println("\t \t MAIN MENU\n"
    	        		+ "Press\n"
    	        		+ "1. USER LOGIN\r\n"
    	        		+ "2. VIEW COURSE CATALOG\r\n"
    	        		+ "3. STUDENT REGISTRATION\r\n"
    	        		+ "4. UPDATE PASSWORD\r\n"
    	        		+ "5. EXIT PORTAL");
    	       try {

       	        String choice = in.next();
       	        switch(choice) {
       	        
       	        case "1": System.out.println("Enter user Id : ");
       					String loginId = in.next();
       					System.out.println("Enter Password");
       					String loginPassword = in.next();
       					
       					//System.out.println("Enter \n 1. FOR STUDENT\r\n 2. FOR PROFESSOR\r\n 3. FOR ADMIN\r\n ");
       		        	//String roles = in.next();
       					user.setUserId(loginId);
       					user.setPassword(loginPassword);
       					userLoginService.login(user);
       					
       	        break;
       	        case "2": 
       	        	CourseDAOInterface courseDataset = new CourseDAOImplementation();
       	        	try {
   						List<Course> courses = courseDataset.view();
   						viewCourses(courses);
   					} catch (NoCourseException e) {
   						// TODO Auto-generated catch block
   						//e.printStackTrace();
   					}
       	        	//System.out.println("Course Catalog will be displayed");
       	        break;
       	        case "3":
       	        	Student student = new Student();
       	        	//System.out.println("Enter user Id : ");
       	    		//String userId = in.next();
       				//student.setUserId(in.next());
       	    		System.out.println("Enter Name : ");
       	    		//String name = in.next();
       	    		student.setStudentName(in.next());
       	    		System.out.println("Enter Password : ");
       	    		//String password = in.next();
       	    		student.setPassword(in.next());
       	    		System.out.println("Enter Branch Name : ");
       	    		student.setBranchName(in.next());
       	    		System.out.println("Enter Address : ");
       	    		student.setAddress(in.next());
       	    		System.out.println("Enter Batch : (start year - end year) ");
       	    		student.setBatch(in.next());
       	    		System.out.println(" Enter phone number : ");
       	    		student.setPhoneNumber(in.next());
       	    		System.out.println("Enter Semester :");
       	    		String sem = in.next();
       	    		student.setSemester(sem);
       	    		User user2 = new User();
       				user2.setName(student.getStudentName());
       				user2.setRole("Student");
       				user2.setUserId(student.getUserId());
       				user2.setPassword(student.getPassword());
       				if(studentServices.validRegistration(student))
       					smenu.register(student, user2);
       	    		//studentServices.addStudent(student, studentDataset);
       	        	//register.registration();
       	        break;
       	        case "4": System.out.println("Enter user id : ");
       	         	String userId = in.next();
       	         	System.out.println("Enter old password : ");
       	         	String old = in.next();
       	         	System.out.println("Enter new password : ");
       	         	String password = in.next();
       	         	userLoginService.updatePassword(userId,old,password);
       	    	break;
       	        case "5": exit = false;
       	        	System.out.println("Exiting!");
       	        	System.exit(0);
       	        break;
       	        default : throw new InvalidEntryException();
       	        }
    	    	   
    	       }catch(InvalidEntryException e) {
    	    	   
    	       }
    	        
    	        
    	      }
       

        in.close();         
	}

	public static void viewCourses(List<Course> courses) {
		System.out.println("------------------------------------------------"); 
		System.out.printf("| %9s | %17s | %10s |", "COURSE CODE","COURSE NAME", "DEPARTMENT");  
		System.out.println();  
		System.out.println("------------------------------------------------");   
		for(Course a : courses){
			System.out.format("| %10s | %18s | %10s |",a.getCourseCode(), a.getCourseName(), a.getDepartmentName());  
			System.out.println();  
		}
		System.out.println("------------------------------------------------"); 
	}
}
