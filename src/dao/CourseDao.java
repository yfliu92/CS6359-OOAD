package dao;

import java.util.List;

import domain.Course;

/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
public interface CourseDao {
	public List<Course> getCourseList();
	public Course getCourse(String id);
	public int getStuNum(String id);
}
