package com.signify.service;

public interface GradeCardInterface {
 //to view grades
	public void viewGrades();
	//to add grades by the professor
	public void addGrades();
	// approving grades by admin
	public void approveGrades();
	//generating reportcard for student
	public void generateReportCard();
}
