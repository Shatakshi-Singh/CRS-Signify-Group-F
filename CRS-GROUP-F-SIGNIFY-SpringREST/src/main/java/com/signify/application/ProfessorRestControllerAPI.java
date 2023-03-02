/**
 * 
 */
package com.signify.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.service.ProfessorInterface;

/**
 * @author WELCOME
 *
 */

@RestController
public class ProfessorRestControllerAPI {
	@Autowired
	private ProfessorInterface professorServices;
	@Autowired
	private Professor professor;
	@Autowired
	private Student student;
	

	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value ="/AssignedCourses/{course}")
	public ResponseEntity ViewEnrolledStudents(@PathVariable String course) {

       	List<Student> students = professorServices.viewEnrolledStudents(course);
       	if(students == null)
       		return new ResponseEntity<>(students, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(students, HttpStatus.OK);
		
	}
	

	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value ="/viewAssignedCourses/{id}")
	public ResponseEntity<List<Course>> displayAssignedCourses(@PathVariable String id) {
		
		List<Course> courses =professorServices.selectCourse(id);
		if(courses == null)			
			return new ResponseEntity<>(courses, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(courses, HttpStatus.OK);
		
	}

	/*
	 * public ResponseEntity getChoosenCourse() {
	 * 
	 * }
	 */
	
	@RequestMapping(
			value = "/addGrade",
			method = RequestMethod.POST
			)
	@ResponseBody
	public ResponseEntity<String> addGrades(@RequestBody Map<String, String> param) {
		
		String student= param.get("studentId");
		String grade = param.get("grade");
		String course = param.get("CourseCode");
		if(professorServices.changeGrade(student, grade, course))

			return new ResponseEntity<>("grade added", HttpStatus.OK);
		else
			return new ResponseEntity<>("enter valid details", HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(
			value = "/editDetails",
			method = RequestMethod.POST
			)
	@ResponseBody
	public ResponseEntity editDetails() {
		//professorServices.editDetails(null, null, null);

		return new ResponseEntity<>( HttpStatus.OK);
	}

}
