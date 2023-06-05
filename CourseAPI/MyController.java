package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import entities.Course;
import services.CourseService;

@RestController
public class MyController {

	@GetMapping("/home")
	public String home() {
		return "Welcome to home";
	}
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseService.getCourse();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String c_id) {
		return this.courseService.getCourse(Long.parseLong(c_id));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String c_id) {
		try{
			courseService.deleteCourse(Long.parseLong(c_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
