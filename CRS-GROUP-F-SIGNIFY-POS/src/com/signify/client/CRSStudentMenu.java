/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Payment;
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
import com.signify.exception.InvalidEntryException;
import com.signify.exception.InvalidPaymentDetails;
import com.signify.exception.NoCourseException;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.RegistrationFailedException;
import com.signify.exception.UserNotFoundException;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentInterface;
import com.signify.service.StudentServices;
import com.signify.validator.PaymentValidator;



public class CRSStudentMenu {

	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
    StudentInterface studentServices = new StudentServices();
    StudentDAOInterface studentDataset = new StudentDAOImplementation();
    Payment payment = new Payment();
    //StudentCollection studentDataset = new StudentCollection();
	
    /**
	 * @param userId
	 * 
	 * function to interact with student client
	 */
	public void display(String userId) {
		System.out.println("\tWELCOME TO STUDENT PANEL");

        Scanner in = new Scanner (System.in);
        
        int sem = studentDataset.getSem(userId);
        boolean exit = true;
     
    	   while(exit) {
    	        System.out.println("------------------------------------------------------");  
    	        System.out.println("PRESS 1 ADD COURSE\r\n"
    	        		+ "PRESS 2 DROP COURSE\r\n"
    	        		+ "PRESS 3 VIEW COURSE CATALOG\r\n"
    	        		+ "PRESS 4 VIEW GRADES\r\n"
    	        		+ "PRESS 5 MAKE FEE PAYMENT\r\n"
    	        		+ "PRESS 6 EDIT USER DETAILS\r\n"
    	        		+ "PRESS 7 EXIT PORTAL");
    	       try {
    	    	   String choice = in.next();
       	        switch(choice) {
       	        case "1":
       	        	
       	        	try {
   						List<Course> courses = courseDataset.viewCoursesForSemester(sem);
						viewCourses(courses);
       					String code = in.next();
       					
       		        	studentServices.addCourse(userId,code,sem);
   					} catch (NoCourseException e) {
   						// TODO Auto-generated catch block
   						//e.printStackTrace();
   					}
       				 
       	        break;
       	        case "2":
       	        	
   					try {
   						List<Course> courses = coursesDataset.viewCourses(userId);
						viewCourses(courses);

       					System.out.println("Enter course code you want to remove.");
       					studentServices.dropCourse(userId, in.next());
   					} catch (NoCourseRegisteredException e) {
   						// TODO Auto-generated catch block
   						///e.printStackTrace();
   					}
       				
       	        	 //todo
       	        break;
       	        case "3":List<Course> courses = new ArrayList<>();;
					try {
						courses = courseDataset.view();
					} catch (NoCourseException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					}
				CRSApplicationMenu.viewCourses(courses);
       	        break;
       	        case "4":if(studentServices.viewGrades(userId))
       	        		result(userId);
       	        	else
       	        	System.out.println("Grade card has not been released yet.");
       	        	
       	        break;
       	        case "5":
       	     	try {
					if(PaymentValidator.canMakePayment(userId)) {
							try {
								List<Course> courses2 = coursesDataset.viewCourses(userId);
								viewCourses(courses2);
							} catch (NoCourseRegisteredException e) {
								// TODO Auto-generated catch block
								///e.printStackTrace();
							}
					    	System.out.println("Make Payment for above registered courses : INR 20000. Enter Mode of Payment\n"
					    		+ "1. BY CARD\r\n"
					    		+ "2. BY UPI ID\r\n"
					    		+ "3. OFFLINE\r\n"
					    		+ "4. EXIT PORTAL\r\n");
					    try {
					    	String choice2 = in.next();
					        switch(choice2) {
					        case "1":try {
					        	System.out.println("Enter Card Type :");
					    		payment.setCardType(in.next());
					    		System.out.println("Enter Card Number :");
					    		String card = in.next();
					    		payment.setCardNumber(card);
					    		System.out.println("Enter CVV :");
					    		String cvv = in.next();
					    		payment.setCvv(cvv);
					    		if(PaymentValidator.validCardNumber(card))
					    			if(PaymentValidator.validCVV(cvv)) {
					    				System.out.println("card");
					    				studentServices.makePayment(userId, payment);
					    				paymentReciept(userId);
					    			}
					        	
					        }catch(InvalidPaymentDetails e) {
					        	
					        }
					        	break;
					        case "2":
								 System.out.println("Enter upiId");
								 String upiId = in.next();
								 payment.setOffline(false);
								 payment.setUpiId(upiId);
								 payment.setStudentId(userId);
						         studentServices.makePayment(userId, payment);
									paymentReciept(userId);
								 
					        break;
					        case "3":
					        	System.out.println("Enter cheque Number : ");
					        	String chequeNumber = in.next();
					        	try {

					   	        	if(PaymentValidator.validCheque(chequeNumber)) {

					       	        	payment.setOffline(true);
					       				payment.setStudentId(userId);
					       	        	payment.setChequeNumber(chequeNumber);
					       	        	studentServices.makePayment(userId, payment);
					    				paymentReciept(userId);
					   	        	}
					        	}catch(InvalidPaymentDetails e) {
					        		
					        	}
					        break;
					        case "4": System.out.println("Exiting.");
					        	break;
					        default :throw new InvalidEntryException();
					    	
					        }
					      }catch(InvalidEntryException e) {
					    	
					    }
						}
				} catch (NoCourseRegisteredException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
       	        catch(RegistrationFailedException e) {
       	        	
       	        }
       	        
       	        break;
       	        case "6":
       	             while(true) {
       	             System.out.println("------------------------------------------------------");
       	        	System.out.println("PRESS 1 EDIT NAME\r\n"
       	            		+ "PRESS 2 EDIT ADDRESS\r\n"
       	            		+ "PRESS 3 EDIT BRANCH NAME\r\n"
       	            		+ "PRESS 4 EDIT BATCH\r\n"
       	            		+ "PRESS 5 EDIT PHONE NUMBER\r\n"
       	            		+ "PRESS 6 EXIT PORTAL");
       	        	String field = in.next();
       	        	if(field.equals("6")) 
       	            	studentServices.editDetails(userId, field, "");
       	        	else{
       	            	System.out.println("Enter correction : ");
       	            	String correction = in.next();
       	            	studentServices.editDetails(userId, field, correction);}
       	        		
       	             }
       	        case "7": exit = false;
       	        	CRSApplicationMenu.main(null);
       	        break;
       	        default :throw new InvalidEntryException();
       	        }
    	    	   
    	       }catch(InvalidEntryException e) {
    	    	   
    	       }
    	   } 
    		
    	     
	}
	/**
	 * @param student object
	 * @param user object
	 * 
	 * to register a student
	 */
    		public void register(Student student, User user) {
    			if(studentServices.addStudent(student, user))
    				System.out.println("Regitration Succesful. Waiting for Approval.");
    			//return true;
    		
       }
    		public void result(String userId) {
    			GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
    			List<Course> courses = gradecard.viewgrades(userId);

				System.out.println("-----------------------------");  
				System.out.printf("| %10s | %10s |", "COURSE CODE ", "GRADE");  
				System.out.println();  
		       	System.out.println("-----------------------------"); 
    			for(Course c : courses) {
    				
    				System.out.format("|%12s | %12s|",c.getCourseCode(), c.getGrade());  
    				System.out.println();
    			}

    	       	System.out.println("----------------------------- \n");  
    			System.out.println("\n\t CPI : "+Double.toString(gradecard.calculateCpi(courses)));
    			
    		}
    		
    		public void viewCourses(List<Course> courses) {
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
    		
    		public void paymentReciept(String userId) {
    			PaymentDAOInterface paymentDataset = new PaymentDAOImplementation();
    			payment = paymentDataset.getAmount(userId);
    			System.out.println("--------------------------------------------------");
    			System.out.println("|                PAYMENT RECEIPT                  ");
    			System.out.println("--------------------------------------------------");
    			System.out.printf("| %20s | %15s |","Amount ", Float.toString(payment.getAmount()));
    			System.out.println();
    			System.out.printf("| %20s | %2s |", "Transaction ID ", payment.getReferenceId());
    			System.out.println();
    			if(payment.getCardNumber()== null)
    				if(payment.getUpiId()== null)
    					System.out.printf("| %20s | %10s |","Cheque Number ", payment.getChequeNumber());
    				else
    					System.out.printf("| %20s | %10s |","UPI Id", payment.getUpiId());
    			else{
    				System.out.printf("| %20s | %20s |","Card Type ", payment.getCardType());
    				System.out.println();
    				System.out.printf("| %20s | %8s |","Card Number ", payment.getCardNumber());
    			}
    			System.out.println();
    			System.out.printf("| %20s | %25s |","Status ", "Paid");
    			System.out.println();
    			System.out.println("--------------------------------------------------");
    		}
}
