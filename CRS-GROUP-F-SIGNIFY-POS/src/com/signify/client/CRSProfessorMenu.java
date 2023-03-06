package com.signify.client;

/**
 * @author CRS_GROUP_E_SIGNIFY
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.dao.CatelogDAOImplementation;
import com.signify.dao.CatelogDAOInterface;
import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.exception.CourseNotAssignedToProfessorException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.InvalidEntryException;
import com.signify.exception.NoCourseException;
import com.signify.exception.NoStudentsRegisteredForCourseException;
import com.signify.service.GradeCardInterface;
import com.signify.service.GradeCardServices;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorService;
import com.signify.service.SemesterRegistrationServices;

public class CRSProfessorMenu {
	
	 CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	 
	public void display(String userId) {
	
        System.out.println("\tWELCOME TO PROFESSOR PANEL");  
        
        //Object creation
        Scanner in = new Scanner (System.in);
        ProfessorInterface professorService = new ProfessorService();
        GradeCardInterface gradeCardServices = new GradeCardServices();
        CourseDAOInterface courseDataset = new CourseDAOImplementation();
        CatelogDAOInterface catelog = new CatelogDAOImplementation();
       
       // Professor professor = new Professor();
        
        
        boolean exit = true;
    	   while(exit) {
    	        System.out.println("------------------------------------------------------");  
    	        System.out.println("PRESS 1 ADD GRADES\r\n"
    	        		+ "PRESS 2 VIEW ENROLLED STUDENTS\r\n"
    	        		+ "PRESS 3 EDIT USER DETAILS\r\n"
    	        		+ "PRESS 4 EXIT PORTAL");
    	       try {
    	    	   String choice = in.next();
       	        switch(choice) {
       	        case "1":
       	        	List<Course> courses = new ArrayList<>();
       	        	String course = "";
       	        	List<String> codes = new ArrayList<>();
       	        	Course c = new Course();
   					try {
   						courses = catelog.getCourse(userId);
   						if(courses.size()>1) {
   							System.out.println("Courses Assigned to you : ");

								System.out.println("----------------");  
								System.out.printf("%10s", "COURSE CODE");  
								System.out.println();  
								System.out.println("----------------");  
   							for(Course a : courses){
   								System.out.format("%7s ",a.getCourseCode());  
   								codes.add(a.getCourseCode());
   								System.out.println();  
   							}
							System.out.println("---------------- \n"); 
   							System.out.println("Enter the course code :");
   							course = in.next();
   							c.setCourseCode(course);
   							if(!codes.contains(c.getCourseCode()))
   								throw new CourseNotFoundException(course);
   								
   						}
   						else
   							course = courses.get(0).getCourseCode();
   							viewStudents(course);

   	    	        	System.out.println("Enter Student Id : ");
   	    	        	String stu = in.next();
   	    	        	System.out.println("Enter Grade : ");
   	    	        	String grade = in.next();
   	    	        	professorService.changeGrade(stu, grade, course);
   						
   					} catch (CourseNotAssignedToProfessorException e) {
   						// TODO Auto-generated catch block
   						//e.printStackTrace();
   					} catch (NoStudentsRegisteredForCourseException e) {
   						// TODO Auto-generated catch block
   						//e.printStackTrace();
   					}catch(CourseNotFoundException e) {
   						
   					}
       	        	

       	        break;
       	        case "2":
       	        	List<Course> courses1 = new ArrayList<>();
       	        	Course c1 = new Course();
       	        	List<String> codes1 = new ArrayList<>();
       	        	String code1;
   					try {
   						courses = catelog.getCourse(userId);
   						if(courses.size()>1) {
   							System.out.println("Courses Assigned to you : ");
   							System.out.println("-------------");  
							System.out.printf("| %10s |", "COURSE CODE");  
							System.out.println();  
							System.out.println("-------------");  
							for(Course a : courses){
								System.out.format("| %10s |",a.getCourseCode()); 
								codes1.add(a.getCourseCode());
								System.out.println();  
							}
						System.out.println("------------- \n"); 
   							System.out.println("Enter the course code :");
   							code1 = in.next();
   							c1.setCourseCode(code1);
   							if(!codes1.contains(c1.getCourseCode()))
   								throw new CourseNotFoundException(code1);
   								
   						}
   						else
   							code1 = courses.get(0).getCourseCode();
   						viewStudents(code1);
   					} catch (CourseNotAssignedToProfessorException e1) {
   						// TODO Auto-generated catch block
   						//e1.printStackTrace();
   					}catch(CourseNotFoundException e) {
   						
   					} catch (NoStudentsRegisteredForCourseException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
       	        break;
       	        case "3":
       	              while(true) {
       	              System.out.println("------------------------------------------------------");
       	         	System.out.println("PRESS 1 EDIT NAME\r\n"
       	             		+ "PRESS 2 EDIT DESIGNATION\r\n"
       	             		+ "PRESS 3 EDIT DEPARTMRNT NAME\r\n"
       	             		+ "PRESS 4 EDIT PHONE NUMBER\r\n"
       	             		+ "PRESS 5 EXIT PORTAL");
       	         	String field = in.next();
       	         	if(field.equals("5")) 
       	             	professorService.editDetails(userId, field, "");
       	         	else{
       	             	System.out.println("Enter correction : ");
       	             	String correction = in.next();
       	             	professorService.editDetails(userId, field, correction);
       	             	}
       	              }
       	        case "4": exit = false;
       	        	CRSApplicationMenu.main(null);
       	        break;
       	        default :throw new InvalidEntryException();
       	        }
    	    	   
    	       }catch(InvalidEntryException e) {
    	    	   
    	       }
    	      }
    	
	}
	public void viewStudents(String course)throws NoStudentsRegisteredForCourseException {

       	List<Student> students = coursesDataset.viewStudents(course);
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


