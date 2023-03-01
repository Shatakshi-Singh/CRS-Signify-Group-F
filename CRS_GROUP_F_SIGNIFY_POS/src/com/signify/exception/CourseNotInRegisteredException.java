package com.signify.exception;

public class CourseNotInRegisteredException extends Exception{
//Exception raise when the user tries to drop the unselected course
	public CourseNotInRegisteredException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when exception is thrown
		 
			System.out.println("You have not added the course you are trying to drop");
	}

}
