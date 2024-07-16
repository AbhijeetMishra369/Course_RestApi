package in.ashokit.rest;

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

import in.ashokit.binding.Course;
import in.ashokit.service.CourseService;

@RestController
public class CourseRestController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) //To read the data from request body
	{
		String status = courseService.upsert(course);
		
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{cId}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cId)
	{
		//To read the data from URL we use @PathVariable
		Course course = courseService.getById(cId);
		
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		List<Course> allCourses = courseService.getAllCourses();
		
		return new ResponseEntity<>(allCourses,HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course)
	{
		String status = courseService.upsert(course);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{cId}")
	public ResponseEntity<String>deteleCourse(@PathVariable Integer cId)
	{
		String status = courseService.deleteById(cId);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
	}

}
