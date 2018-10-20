package dao;

import java.util.List;

import domain.Course;
import domain.User;

/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
public interface StudentDao {
	public String register(String course_id,String stu_id);
	public String drop(String course_id,String stu_id);
	public User getStuInfo(String id);
	public List<Course> getStuCourse(String id);
	public List<Course> searchCourse(String cname,String cno,String sno,String prefix,String year,String semester,String tid);
}
