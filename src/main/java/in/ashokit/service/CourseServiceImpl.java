package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Course;
import in.ashokit.repo.CourseRepo;
@Service
public class CourseServiceImpl implements CourseService 
{
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public String upsert(Course course) 
	{
		// insert and update
		
		courseRepo.save(course);  //save() internally use upsert operation based on pk
		return "success";
	}

	@Override
	public Course getById(Integer cId) 
	{
		Optional<Course> findById = courseRepo.findById(cId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() 
	{
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cId) 
	{
	   if(courseRepo.existsById(cId))
	   {
		   courseRepo.deleteById(cId);
		   return "Delete Success";
	   }
	   else
	   {
		   return "No record found";
		   
	   }	
	}

}
