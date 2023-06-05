package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
