/**
 * 
 */
package com.signify.validator;

import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.exception.InvalidPaymentDetails;
import com.signify.exception.NoCourseRegisteredException;
import com.signify.exception.RegistrationFailedException;

/**
 * @author GROUP-E-CRS-SIGNIFY
 *
 */
public class PaymentValidator {
	static CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	/**
		Method to check whether the Student have selected all the necessary course for making payment 
		@return Exception if occurred
	
	**/
	public static boolean canMakePayment(String userId)	throws RegistrationFailedException, NoCourseRegisteredException{
		int courses = coursesDataset.countCourseStudent(userId);
		if(courses <6)
			throw new  RegistrationFailedException(" not having 6 courses. Please add courses.");
		return true;
	}
	
	public static boolean validCVV(String cvv) throws InvalidPaymentDetails {
		if(cvv.length()==3)
			if (isNumeric(cvv))
				return true;
			
	    throw new InvalidPaymentDetails("Wrong CVV.");
		
		
	}
	public static boolean validCardNumber(String cardNumber) throws InvalidPaymentDetails {
		if(cardNumber.length()==16)
			if(isNumeric(cardNumber))
				return true;

	    throw new InvalidPaymentDetails("Wrong Card Number.");
	}
	
	public static boolean validCheque(String cheque) throws InvalidPaymentDetails {
		if(cheque.length()==6)
			if(isNumeric(cheque))
				return true;

	    throw new InvalidPaymentDetails("Wrong Cheque Number.");
	}
	
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			long a = Long.parseLong(strNum);
		} catch (NumberFormatException nfe) {
			return false;
			// throws invalid user exception
		}
		return true;
	}

}
