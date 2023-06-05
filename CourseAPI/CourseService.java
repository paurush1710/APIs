package services;
import java.util.*;

import entities.Course;

public interface CourseService {
	
	public List<Course> getCourse();
	public Course getCourse(long c_id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long c_id);

}
