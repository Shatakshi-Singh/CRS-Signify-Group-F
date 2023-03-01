package com.signify.exception;

public class NoProfessorInDatasetException extends Exception{

	public NoProfessorInDatasetException() {
		// TODO Auto-generated constructor stub
		super();
		//Message returned when exception is thrown
		
		System.out.println("Ther are no professors in dataset.");
	}

}
