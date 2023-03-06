/**
 * 
 */
package com.signify.client;

/**
 * @author CRS_GROUP_E_SIGNIFY
 *
 */
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
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.InvalidEntryException;
import com.signify.exception.NoCourseException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServices;
import com.signify.service.StudentServices;

public class CRSAdminMenu {
	/**
	 * displays menu for admin services
	 */
	
    AdminInterface adminServices = new AdminServices();
    
	public void display()  {
    System.out.println("\tWELCOME TO ADMIN PANEL");        
    
    Scanner in = new Scanner (System.in);
    CRSAdminMenu amenu = new CRSAdminMenu();
    Admin admin = new Admin();
	UserDAOInterface userDataset = new UserDAOImplementation();
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	
    boolean exit = true;
    	/*
    	 * Menu driven approach for displaying 
    	 * Student functions - Approving Students, Viewing Enrolled students
    	 * Professor function -- Adding or removing professor, assigning course to professor, viewing profesors
    	 * Admin function - Adding or removing admin.
    	 */
        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("PRESS 1 STUDENT FUNCTIONS\r\n"
        		+ "PRESS 2 PROFESSOR FUNCTIONS\r\n"
        		+ "PRESS 3 COURSE FUNCTIONS\r\n"
        		+ "PRESS 4 ADMIN ACCESS\r\n"
        		+ "PRESS 5 EXIT PORTAL");
        try {
        	String choice = in.next();
            switch(choice) {
            case "1":
            	 boolean exit1 = true;
            	    while(exit1) {
            	    System.out.println("------------------------------------------------------");  
            	    System.out.println("PRESS 1 APPROVE STUDENT REGISTRATION\r\n"
            	    		+ "PRESS 2 VIEW ENROLLED STUDENTS\r\n"
            	    		+ "PRESS 3 EXIT PORTAL");
            	    try {
            	    	String choice1 = in.next();
                	    switch(choice1) {
                	    case "1":
                			//StudentCollection.printUnapproved();
                			try {
        						userDataset.getUnapproved();
        					} catch (StudentNotFoundForApprovalException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
                			System.out.println("\n1.TO APPROVE ALL STUDENTS\n"+"2.APPROVE ONE STUDENT\n"+"3.EXIT\n");
                			 
                			
                			try {
                				String approve=in.next();
                				switch(approve)
                    			{
                    			case "1":
                    				//System.out.println("To approve all the  Students");
                    				adminServices.approveAllStudents();
                    			break;
                    			case "2":
                    				System.out.println("Enter User id.");
                						adminServices.approveStudent(in.next());	
                    			break;
                    			case "3": System.out.println("Exiting.\n");
                        	    	//amenu.display(); 
                    			break;
                    			default: throw new InvalidEntryException();
                    			}
                				
                			}catch(InvalidEntryException e) {
                				
                			}
                	    break;
                	    case "2":viewEnrolled();
                	    break;
                	    case "3": exit1 = false;
                	    	amenu.display(); 
                	    break;
                	    default :throw new InvalidEntryException();
                	    }
            	    	
            	    }catch(InvalidEntryException e) {
            	    	
            	    }
            	    }
            break;
            case "2":
            	 boolean exit2 = true;
         	    while(exit2) {
         	    System.out.println("------------------------------------------------------");  
         	    System.out.println("PRESS 1 ADD NEW PROFESSOR\r\n"
         	    		+ "PRESS 2 ASSIGN COURSE TO PROFESSOR\r\n"
         	    		+ "PRESS 3 VIEW PROFESSORS\r\n"
         	    		+ "PRESS 4 REMOVE PROFESSOR\r\n" 	    		
         	    		+ "PRESS 5 EXIT PORTAL");
         	   try {
         		  String choice2 = in.next();
          	    switch(choice2) {
          	    case "1":Professor professor = new Professor();
          	    	System.out.println("Enter Professor Name : ");
          	    	professor.setProfessorName(in.next());
          	    	System.out.println("Enter Password :");
          	    	professor.setPassword(in.next());
          	    	System.out.println("Enter Professor Designatiion : ");
          	    	professor.setDesignation(in.next());
          	    	System.out.println("Enter Professor's Department : ");
          	    	professor.setDepartmentName(in.next());
          	    	System.out.println("Enter Phone number : ");
          	    	professor.setPhoneNumber(in.next());
          	    	//System.out.println("Enter Course code assigned :");
          	    	//professor.setAssignedCourse(in.next());
          	    	adminServices.addProfessor("", professor); 
          	    break;
          	    case "2":
          	    	try {
          	    		courseDataset.view();
          	    	}catch(NoCourseException e) {
          	    		
          	    	}
          	    	System.out.println("Enter the course code : ");
          	    	String courseCode = in.next();
          	    	System.out.println("Enter the professor id : ");
          	    	String professorId = in.next();
          	    	adminServices.assignCourse(courseCode, professorId); 
          	    break;
          	    case "3": adminServices.viewProfesssors();
             	break;
          	    case "4":
          	    	adminServices.viewProfesssors();
          	    	System.out.println("Enter Professor id : ");
          	    	adminServices.removeProfessor(in.next());
          	    break;
          	    case "5": exit2 = false;
         	    	amenu.display();
         	    break;
          	    default :throw new InvalidEntryException();
          	    }
         	   }catch(InvalidEntryException e) {
         		   
         	   }
        	    }
            break;
            case "3":
            	 boolean exit3 = true;
          	    while(exit3) {
          	    System.out.println("------------------------------------------------------");  
          	    System.out.println("PRESS 1 ADD NEW COURSE\r\n"
          	    		+ "PRESS 2 REMOVE COURSE\r\n"
          	    		+ "PRESS 3 GENERATE REPORT CARD\r\n"
          	    		+ "PRESS 4 VIEW COURSE CATALOG\r\n"
          	    		+ "PRESS 5 EXIT PORTAL");
          	   try {
          		 String choice3 = in.next();
           	    switch(choice3) {
           	    case "1": 
           	    	Course course = new Course();
           	    	System.out.println("Enter Course Code : ");
           	    	course.setCourseCode(in.next());
           	    	System.out.println("Enter Course Name : ");
           	    	course.setCourseName(in.next());
           	    	System.out.println("Enter Department : ");
           	    	course.setDepartmentName(in.next());
           	    	System.out.println("Enter Semester:");
           	    	course.setSemester(in.next());
           	    	adminServices.addCourse(course); 
           	    break;
           	    case "2":
           	    	try {
     					courseDataset.view();
     	      	    	System.out.println("Enter course code for course to be removed : ");
     	      	    	String courseCode = in.next();
     	      	    	adminServices.dropCourse(courseCode); 
     				} catch (NoCourseException e) {
     					// TODO Auto-generated catch block
     					//e.printStackTrace();
     				}
           	    break;
           	    case "3":adminServices.generateReportCard(); //todo
                 break;
           	    case "4":List<Course> courses = adminServices.courseDetails();
					CRSApplicationMenu.viewCourses(courses);
           	    break;
           	    case "5": exit2 = false;
           	    	amenu.display();
           	    break;
           	    default :throw new InvalidEntryException();
           	    }
          		   
          	   }catch(InvalidEntryException e) {
          		   
          	   }
          	    }
            break;
            case "4":
            	boolean exit4 = true;
          	    while(exit4) {
          	    System.out.println("------------------------------------------------------");  
          	    System.out.println("PRESS 1 ADD ADMIN\r\n"
          	    		+ "PRESS 2 REMOVE ADMIN\r\n"
          	    		+ "PRESS 3 UPDATE ADMIN DETAILS\r\n"
          	    		+ "PRESS 4 EXIT PORTAL");
          	    try {
          	    	
          	    	String choice4 = in.next();
              	    switch(choice4) {
              	    case "1":
              	    	User user1 = new User();
              	    	Admin admin1 = new Admin();
            	    	System.out.println("Enter Name : ");
            	    	admin1.setAdminName(in.next());
            	    	System.out.println("Enter Password : ");
            	    	admin1.setPassword(in.next());
            			user1.setName(admin1.getAdminName());
            			user1.setRole("Admin");
            			user1.setUserId(admin1.getAdminId());
            			user1.setPassword(admin1.getPassword());
            	    	if(adminServices.addAdmin(admin1, user1))
            	    		System.out.println("Admin added.");
            	    	else
            	    		System.out.println("This user Id already exists.");
            	    	
              	    break;
              	    case "2":
              	    	Admin admin2 = new Admin();
              	    	System.out.println("Enter Name : ");
              	    	admin2.setAdminName(in.next());
              	    	System.out.println("Enter Admin Id : ");
              	    	admin2.setAdminId(in.next());
              	    	System.out.println("Enter Password : ");
              	    	admin2.setPassword(in.next());
              	    	adminServices.removeAdmin(admin2); 
              	    break;
              	    case "3":// input and create method
              	    	Admin old = new Admin();
              	    	Admin newAdmin = new Admin();
              	    	System.out.println("Enter old Name : ");
              	    	old.setAdminName(in.next());
              	    	System.out.println("Enter Admin Id : ");
              	    	old.setAdminId(in.next());
              	    	System.out.println("Enter old Password : ");
              	    	old.setPassword(in.next());
              	    	System.out.println("Enter new Name : ");
            	    	newAdmin.setAdminName(in.next());
            	    	newAdmin.setAdminId(old.getAdminId());
            	    	System.out.println("Enter new Password : ");
            	    	newAdmin.setPassword(in.next());
              	    	adminServices.editAdminDetails(old, newAdmin);
                    break;
              	    case "4": exit2 = false;
              	    	amenu.display();
              	    break;
              	    default :throw new InvalidEntryException();
              	    }
          	    	
          	    }catch(InvalidEntryException e) {
          	    	
          	    }
          	    }
            break;
            case "5": exit = false;
            	CRSApplicationMenu.main(null);
            break;
            default :throw new InvalidEntryException();//handles invalid entries
            }
        	
        }catch(InvalidEntryException e) {
        	
        }
        
       
      }
    }
	
	public void viewEnrolled() {
		adminServices.viewEnrolledStudents();
		List<Student> students = adminServices.viewEnrolledStudents();
       	System.out.println("-----------------------------");  
		System.out.printf("| %10s | %15s |", "STUDENT ID ", "NAME");  
		System.out.println();  
       	System.out.println("-----------------------------");  
		for(Student a : students){
			System.out.format("|%12s | %15s|",a.getUserId(), a.getStudentName());  
			System.out.println();  
		}
       	System.out.println("----------------------------- \n");  
	}
    

}
