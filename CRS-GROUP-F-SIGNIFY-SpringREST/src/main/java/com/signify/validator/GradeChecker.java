/**
 * 
 */
package com.signify.validator;

/**
 * @author GROUP H
 *
 */
public class GradeChecker {

	public static boolean isValidGrade(String grade) {
		if(grade.endsWith("A"))
			return true;
		else if(grade.endsWith("B"))
			return true;
		else if(grade.endsWith("C"))
			return true;
		else if(grade.endsWith("D"))
			return true;
		else if(grade.endsWith("E"))
			return true;
		System.out.println("Grade not valid.");
		return false;
	}

}
