package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.Course;


public interface CourseService 
{
	public String upsert(Course course);  //insert and update
	
	public Course getById(Integer cId);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cId);

}
