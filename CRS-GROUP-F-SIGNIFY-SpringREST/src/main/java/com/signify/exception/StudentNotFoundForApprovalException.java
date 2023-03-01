package com.signify.exception;

public class StudentNotFoundForApprovalException extends Exception {

	public StudentNotFoundForApprovalException() {
		// TODO Auto-generated constructor stub
		super();
		/**
		 * Message returned when com.signify.exception is thrown
		 */
		System.out.println("Student was not found for approval.");
	}

}
