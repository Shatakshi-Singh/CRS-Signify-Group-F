package com.signify.application;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.service.AdminInterface;



@RestController

public class AdminRestControllerAPI {
	
	@Autowired
	private AdminInterface adminService;
	@Autowired
	private Admin admin;
	@Autowired
	private Course course;
	@Autowired
	private User user;
	@Autowired
	private Professor professor;

	@RequestMapping(
			value = "/createAdmin",
			method = RequestMethod.POST
			)
	@ResponseBody
	public ResponseEntity<String> addAdmin(@RequestBody Map<String,String> param) {
		
		String name = param.get("name");
		String password = param.get("password");
		admin.setAdminName(name);
		admin.setPassword(password);
		if(adminService.addAdmin(admin))
			return new ResponseEntity<String>("added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(
		    method = RequestMethod.GET,
		    value ="/deleteAdmin/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable String id) {

		if (adminService.removeAdmin(id)) {

			return new ResponseEntity<String>("delted.", HttpStatus.OK);
		}

		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	}	

	@RequestMapping(
			value = "/createCourse",
			method = RequestMethod.POST
			)
	@ResponseBody
	public ResponseEntity<String> addCourse(@RequestBody Map<String, String> param) {
		course.setCourseCode(param.get("courseCode"));
		course.setCourseName(param.get("courseName"));
		course.setDepartmentName(param.get("departmentName"));
		course.setSemester(param.get("semester"));
		
		boolean response = adminService.addCourse(course);
		if(response)
		return new ResponseEntity<String>("Course added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Course has already been added.", HttpStatus.OK);
	}
	

	@RequestMapping(
		    method = RequestMethod.GET,
		    value ="/deleteCourse/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable String id) {

		if (adminService.dropCourse(id)) {

			return new ResponseEntity<String>("Course deleted.", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Course was not found.",HttpStatus.NOT_FOUND);

	}	
	@RequestMapping(
			value = "/addProfessor",
			method = RequestMethod.POST
			)
	@ResponseBody
	public ResponseEntity<String> addProfessor(@RequestBody Map<String, String> param) {
		
		professor.setPassword(param.get("password"));
		professor.setPhoneNumber(param.get("phoneNumber"));
		professor.setDepartmentName(param.get("departmentName"));
		professor.setDesignation(param.get("designation"));
		professor.setProfessorName(param.get("professorName"));
		
		
		 adminService.addProfessor(professor);
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}
	

	@RequestMapping( 
		    method = RequestMethod.GET,
		    value ="/deleteProfessor/{id}")
	public ResponseEntity<String> deleteProfessor(@PathVariable String id) {

		if (adminService.removeProfessor(id)) {

			return new ResponseEntity<String>(" Professor deleted.", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Professor was not found.",HttpStatus.NOT_FOUND);

	}	
	
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value ="/viewCourses")
	public ResponseEntity<List<Course>> viewCourses() {

		List<Course> courses = adminService.courseDetails();
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
		

	}	
	

	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value ="/viewEnrolledStudents")
	public ResponseEntity<List<Student>> viewEnrolledStudents() {

		List<Student> students = adminService.viewEnrolledStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.NOT_FOUND);

	}	
	
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value ="/approveOne/{id}")
	public ResponseEntity  approveOne(@PathVariable String id){
		List<Student> students = adminService.approveStudent(id);
		if(students == null)
			return new ResponseEntity<String>("No student found for approval.",HttpStatus.NOT_FOUND);
		else

			return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(
		    method = RequestMethod.GET,
		    value ="/approveAll")
	public ResponseEntity approveAll(){
		List<Student> students = adminService.approveAllStudents();
		if(students == null)
			return new ResponseEntity<String>("No students found for approval.",HttpStatus.NOT_FOUND);
		else

			return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
			
		
	}
	
	@RequestMapping(
			value = "/assignCourse",
			method = RequestMethod.POST
			)
	@ResponseBody
	public ResponseEntity<String> assignCourse(@RequestBody Map<String,String> param) {
		
		String courseCode = param.get("course");
		String professor = param.get("professor");
		String response = adminService.assignCourse(courseCode, professor);
		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}
	@RequestMapping( 
		    method = RequestMethod.GET,
		    value ="/generateReportCard")
	public ResponseEntity<String> generateReportCard(){
		
		if(adminService.generateReportCard())
			return new ResponseEntity<String>("Report Card Generated.",HttpStatus.OK);
		else

			return new ResponseEntity<String>(" No students were found for grading.",HttpStatus.NOT_FOUND);
			
		
	}
	

}
