package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CourseDao;
import entities.Course;

public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	
	@Override
	public List<Course> getCourse() {
		return courseDao.findAll();
		 
	}

	@Override
	public Course getCourse(long c_id) {
		return courseDao.getOne(c_id);
		 
	}

	@Override
	public Course addCourse(Course course) {
	 courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long c_id) {
		Course c = courseDao.getOne(c_id);
		courseDao.delete(c);
		
	}	
	
}
