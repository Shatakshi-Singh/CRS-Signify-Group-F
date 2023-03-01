/**
 * 
 */
package com.signify.service;

/**
 * @author BHAVISH
 *
 */
public class GradeCardServices implements GradeCardInterface{

	@Override
	public void viewGrades() {
		// TODO Auto-generated method stub
		System.out.println("Grades Displayed");
	}

	@Override
	public void addGrades() {
		// TODO Auto-generated method stub
		System.out.println("Grades added");
		
	}

	@Override
	public void approveGrades() {
		// TODO Auto-generated method stub
		System.out.println("Grades approved");
	}

	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		System.out.println("Report card generated");
	}

}
