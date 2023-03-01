/**
 * 
 */
package com.signify.service;

import java.util.Date;

import org.springframework.stereotype.Service;


/**
 * @author GROUP H
 *
 */

@Service
public  class SemesterRegistrationServices implements SemesterRegistrationInterface
{
	public void registerCourses(String studentId, int Semester, Date dateOfJoining){
		System.out.println("regiistered courses");
	}
	public void addCourse(String studentId, int Semester, String courseCode){
		System.out.println("Course added.");
	}
	public void dropCourse(String studentId, int Semester, String courseCode){
		System.out.println("course dropped.");
	}
	public void optCourse() {
		System.out.println("opted course by professor");
	}
	public void registration() {
		System.out.println("You have entered Registtration Panel!");
	}
	 	
	
	public void payfees(){
		System.out.println("direction to payment panel");
		// shouldnt be here i think
	}
	public void generateRegistionId() {
		System.out.println("id generated");
	}
	public void getSemesterDetails(){
		System.out.println("fetching semester details..");
		
	}
	@Override
	public void viewCourseDetails() {
		// TODO Auto-generated method stub
		
		
	}
}
